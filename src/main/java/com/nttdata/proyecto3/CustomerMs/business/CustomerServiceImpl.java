package com.nttdata.proyecto3.CustomerMs.business;

import com.nttdata.proyecto3.AccountMs.business.AccountService;
import com.nttdata.proyecto3.AccountMs.model.entity.Account;
import com.nttdata.proyecto3.CustomerMs.model.entity.Customer;
import com.nttdata.proyecto3.CustomerMs.repository.CustomerRepository;
import com.nttdata.proyecto3.model.AccountResponse;
import com.nttdata.proyecto3.model.CustomerRequest;
import com.nttdata.proyecto3.model.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    private AccountService accountService;

    @Override
    public List<CustomerResponse> listCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::getCustomerResponseOfCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        return customerMapper.getCustomerResponseOfCustomer(
                customerRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"))
        );
    }

    @Override
    public CustomerResponse registerCustomer(CustomerRequest customerRequest) {

        customerRepository.findByDni(customerRequest.getDni())
                .ifPresent(customer -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "El DNI ya está registrado: " + customerRequest.getDni());
                });

        Optional.ofNullable(customerRequest.getEmail())
                .filter(email -> email.contains("@") && email.contains("."))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "El correo electrónico debe ser válido"));

        return customerMapper.getCustomerResponseOfCustomer(customerRepository
                .save(customerMapper.getCustomerOfCustomerRequest(customerRequest)));
    }

    @Override
    public CustomerResponse updateCustomer(String id, CustomerRequest customerRequest) {
        return customerRepository.findById(id)
                .map(existingCard -> {
                    Customer updatedCard = customerMapper.getCustomerOfCustomerRequest(customerRequest);
                    updatedCard.setId(existingCard.getId());
                    return customerRepository.save(updatedCard);
                })
                .map(customerMapper::getCustomerResponseOfCustomer)
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));
    }

    @Override
    public void deleteCustomerById(String id) {

        // SE OPTÓ POR INYECCION DE DEPENDENCIAS PARA LA COMUNICACION
        // EN FUTURAS ITERACIONES SE UTILIZARÁ KAFKA O RABBITMQ

        // Verificar si el cliente tiene cuentas activas
        List<AccountResponse> accounts = accountService.listAccounts().stream()
                .filter(account -> account.getClienteId().equals(id))
                .toList();
        // Verificar si hay cuentas activas
        if (!accounts.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El cliente tiene cuentas activas y no se puede eliminar");
        }

        customerRepository.findById(id)
                .ifPresentOrElse(customerRepository::delete,
                        () -> { throw new NoSuchElementException("Cliente no encontrado"); });
    }
}
