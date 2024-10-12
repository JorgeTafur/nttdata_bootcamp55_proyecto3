package com.nttdata.proyecto3.CustomerMs.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.nttdata.proyecto3.AccountMs.business.AccountService;
import com.nttdata.proyecto3.CustomerMs.model.entity.Customer;
import com.nttdata.proyecto3.CustomerMs.repository.CustomerRepository;
import com.nttdata.proyecto3.model.CustomerRequest;
import com.nttdata.proyecto3.model.CustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("when add customer ok")
    void whenAddCustomerOk() {
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setEmail("jorge@gmail.com");
        customerRequest.setApellido("Tafur");
        customerRequest.setId(1L);
        customerRequest.setNombre("Jorge");
        customerRequest.setDni("74582556");

        Customer customer = new Customer();
        customer.setEmail("jorge@gmail.com");
        customer.setApellido("Tafur");
        customer.setId(1L);
        customer.setNombre("Jorge");
        customer.setDni("74582556");

        CustomerResponse expectedResponse = new CustomerResponse();
        expectedResponse.setNombre("Jorge");
        expectedResponse.setApellido("Tafur");

        // Simula el comportamiento del mapper y del repositorio
        when(customerMapper.getCustomerOfCustomerRequest(customerRequest)).thenReturn(customer);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        when(customerMapper.getCustomerResponseOfCustomer(customer)).thenReturn(expectedResponse);

        // Llama al método y verifica el resultado
        CustomerResponse savedCustomer = customerService.registerCustomer(customerRequest);
        assertEquals(expectedResponse, savedCustomer);
    }

    @Test
    @DisplayName("when get list customer ok")
    void whenGetListCustomerOk() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setNombre("Jorge");
        customer1.setApellido("Tafur");
        customer1.setDni("74582556");
        customer1.setEmail("jorge@gmail.com");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setNombre("Daniela");
        customer1.setApellido("Navarro");
        customer2.setDni("72888269");
        customer1.setEmail("daniela@gmail.com");

        Customer customer3 = new Customer();
        customer3.setId(3L);
        customer3.setNombre("Coco");
        customer3.setApellido("Villagarcia");
        customer3.setDni("78945612");
        customer1.setEmail("coco@gmail.com");

        List<Customer> customerList = Arrays.asList(customer1, customer2, customer3);

        when(customerRepository.findAll()).thenReturn(customerList);

        CustomerResponse response1 = new CustomerResponse();
        response1.setId(1L);
        response1.setNombre("Jorge");
        response1.setApellido("Tafur");
        response1.setDni("74582556");
        response1.setEmail("jorge@gmail.com");
        CustomerResponse response2 = new CustomerResponse();
        response2.setId(2L);
        response2.setNombre("Daniela");
        response2.setApellido("Navarro");
        response2.setDni("72888269");
        response2.setEmail("daniela@gmail.com");
        CustomerResponse response3 = new CustomerResponse();
        response3.setId(3L);
        response3.setNombre("Coco");
        response3.setApellido("Villagarcia");
        response3.setDni("78945612");
        response3.setEmail("coco@gmail.com");

        when(customerMapper.getCustomerResponseOfCustomer(customer1)).thenReturn(response1);
        when(customerMapper.getCustomerResponseOfCustomer(customer2)).thenReturn(response2);
        when(customerMapper.getCustomerResponseOfCustomer(customer3)).thenReturn(response3);

        // Llama al método y verifica el resultado
        List<CustomerResponse> foundCustomers = customerService.listCustomers();
        assertEquals(3, foundCustomers.size());

        assertEquals(1L, foundCustomers.get(0).getId());
        assertEquals("Jorge", foundCustomers.get(0).getNombre());
        assertEquals("Tafur", foundCustomers.get(0).getApellido());
        assertEquals("74582556", foundCustomers.get(0).getDni());
        assertEquals("jorge@gmail.com", foundCustomers.get(0).getEmail());

        assertEquals(2L, foundCustomers.get(1).getId());
        assertEquals("Daniela", foundCustomers.get(1).getNombre());
        assertEquals("Navarro", foundCustomers.get(1).getApellido());
        assertEquals("72888269", foundCustomers.get(1).getDni());
        assertEquals("daniela@gmail.com", foundCustomers.get(1).getEmail());

        assertEquals(3L, foundCustomers.get(2).getId());
        assertEquals("Coco", foundCustomers.get(2).getNombre());
        assertEquals("Villagarcia", foundCustomers.get(2).getApellido());
        assertEquals("78945612", foundCustomers.get(2).getDni());
        assertEquals("coco@gmail.com", foundCustomers.get(2).getEmail());
    }
/*
    @Test
    @DisplayName("when update customer ok")
    void whenUpdateCustomerOk() {
        // Crear un CustomerRequest para actualizar
        CustomerRequest updateRequest = new CustomerRequest();
        updateRequest.setId(1L); // Este puede ser opcional si no lo usas en el mapeo
        updateRequest.setNombre("Jorge Actualizado");
        updateRequest.setApellido("Tafur");
        updateRequest.setDni("74582556");
        updateRequest.setEmail("jorge_actualizado@gmail.com");

        // Simular el Customer que se va a actualizar
        Customer existingCustomer = new Customer();
        existingCustomer.setId(1L);  // Este ID debe coincidir
        existingCustomer.setNombre("Jorge");
        existingCustomer.setApellido("Tafur");
        existingCustomer.setDni("74582556");
        existingCustomer.setEmail("jorge@gmail.com");

        // Simular el Customer actualizado
        Customer updatedCustomer = new Customer();
        updatedCustomer.setId(1L);
        updatedCustomer.setNombre("Jorge Actualizado");
        updatedCustomer.setApellido("Tafur");
        updatedCustomer.setDni("74582556");
        updatedCustomer.setEmail("jorge_actualizado@gmail.com");

        // Simular el comportamiento del repositorio y el mapper
        when(customerRepository.findById(existingCustomer.getId().toString())).thenReturn(Optional.of(existingCustomer));
        when(customerMapper.getCustomerOfCustomerRequest(updateRequest)).thenReturn(updatedCustomer);
        when(customerRepository.save(any(Customer.class))).thenReturn(updatedCustomer);


        // Llama al método y verifica el resultado
        CustomerResponse response = customerService.updateCustomer(existingCustomer.getId().toString(), updateRequest);

        // Verificaciones
        assertEquals("Jorge Actualizado", response.getNombre());
        assertEquals("jorge_actualizado@gmail.com", response.getEmail());

        // Verificar que el método save fue llamado
        verify(customerRepository, times(1)).save(updatedCustomer);
    }*/

    @Test
    @DisplayName("when update customer not found")
    void whenUpdateCustomerNotFound() {
        // Crear un CustomerRequest para actualizar
        CustomerRequest updateRequest = new CustomerRequest();
        updateRequest.setId(1L); // Este puede ser opcional si no lo usas en el mapeo
        updateRequest.setNombre("Jorge Actualizado");
        updateRequest.setApellido("Tafur");
        updateRequest.setDni("74582556");
        updateRequest.setEmail("jorge_actualizado@gmail.com");

        // Simular que no se encuentra el Customer
        when(customerRepository.findById(updateRequest.getId().toString())).thenReturn(Optional.empty());

        // Verifica que se lanza NoSuchElementException
        assertThrows(NoSuchElementException.class, () -> {
            customerService.updateCustomer(updateRequest.getId().toString(), updateRequest);
        });
    }


    @Test
    @DisplayName("when delete customer ok")
    void whenDeleteCustomerOk() {
        Long customerId = 1L;

        // Crear un Customer simulado
        Customer existingCustomer = new Customer();
        existingCustomer.setId(customerId);
        existingCustomer.setNombre("Jorge");
        existingCustomer.setApellido("Tafur");

        // Simular el comportamiento del repositorio
        when(customerRepository.findById(customerId.toString())).thenReturn(Optional.of(existingCustomer));

        // Llama al método de eliminación
        customerService.deleteCustomerById(customerId.toString());

        // Verificar que se haya llamado al método delete en el repositorio
        verify(customerRepository, times(1)).delete(existingCustomer);
    }


    @Test
    @DisplayName("when delete customer not found")
    void whenDeleteCustomerNotFound() {
        Long customerId = 1L;

        // Simular que el cliente no existe
        lenient().when(customerRepository.existsById(customerId.toString())).thenReturn(false);

        // Verificar que se lance una excepción cuando el cliente no existe
        assertThrows(NoSuchElementException.class, () -> {
            customerService.deleteCustomerById(customerId.toString());
        });
    }
}
