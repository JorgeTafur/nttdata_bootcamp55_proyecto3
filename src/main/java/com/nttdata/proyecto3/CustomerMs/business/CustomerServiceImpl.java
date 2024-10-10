package com.nttdata.proyecto3.CustomerMs.business;

import com.nttdata.proyecto3.CustomerMs.model.entity.Customer;
import com.nttdata.proyecto3.CustomerMs.repository.CustomerRepository;
import com.nttdata.proyecto3.model.CustomerRequest;
import com.nttdata.proyecto3.model.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

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
                        .orElseThrow(() -> new NoSuchElementException("Credit Card not found"))
        );
    }

    @Override
    public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
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
                .orElseThrow(() -> new NoSuchElementException("Credit Card not found"));
    }

    @Override
    public void deleteCustomerById(String id) {
        customerRepository.findById(id)
                .ifPresentOrElse(customerRepository::delete,
                        () -> { throw new NoSuchElementException("Credit Card not found"); });
    }
}
