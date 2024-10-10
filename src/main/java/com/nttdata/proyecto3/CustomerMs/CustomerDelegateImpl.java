package com.nttdata.proyecto3.CustomerMs;

import com.nttdata.proyecto3.api.ClientesApiDelegate;
import com.nttdata.proyecto3.CustomerMs.business.CustomerService;
import com.nttdata.proyecto3.model.CustomerRequest;
import com.nttdata.proyecto3.model.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDelegateImpl implements ClientesApiDelegate {

    @Autowired
    CustomerService customerService;

    @Override
    public ResponseEntity<List<CustomerResponse>> listCustomers() {
        return ResponseEntity.ok(customerService.listCustomers());
    }

    @Override
    public ResponseEntity<CustomerResponse> getCustomerById(String id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @Override
    public ResponseEntity<CustomerResponse> registerCustomer(CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.registerCustomer(customerRequest));
    }

    @Override
    public ResponseEntity<CustomerResponse> updateCustomer(String id, CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerRequest));
    }

    @Override
    public ResponseEntity<Void> deleteCustomerById(String id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }

}
