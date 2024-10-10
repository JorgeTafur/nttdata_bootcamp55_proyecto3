package com.nttdata.proyecto3.CustomerMs.business;


import com.nttdata.proyecto3.model.CustomerRequest;
import com.nttdata.proyecto3.model.CustomerResponse;

import java.util.List;


public interface CustomerService {

    List<CustomerResponse> listCustomers();
    CustomerResponse getCustomerById(String id);
    CustomerResponse registerCustomer(CustomerRequest customerRequest);
    CustomerResponse updateCustomer(String id, CustomerRequest customerRequest);
    void deleteCustomerById(String id);
}
