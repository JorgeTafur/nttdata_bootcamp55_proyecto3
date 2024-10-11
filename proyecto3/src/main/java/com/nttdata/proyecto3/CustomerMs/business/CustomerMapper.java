package com.nttdata.proyecto3.CustomerMs.business;

import com.nttdata.proyecto3.CustomerMs.model.entity.Customer;
import com.nttdata.proyecto3.model.CustomerRequest;
import com.nttdata.proyecto3.model.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer getCustomerOfCustomerRequest(CustomerRequest request){
        Customer entity = new Customer();
        entity.setNombre(request.getNombre());
        entity.setApellido(request.getApellido());
        entity.setDni(request.getDni());
        entity.setId(request.getId());
        entity.setEmail(request.getEmail());
        return entity;

    }

    public CustomerResponse getCustomerResponseOfCustomer(Customer entity){
        CustomerResponse response = new CustomerResponse();
        response.setNombre(entity.getNombre());
        response.setApellido(entity.getApellido());
        response.setDni(entity.getDni());
        response.setId(entity.getId());
        response.setEmail(entity.getEmail());
        return response;

    }
}
