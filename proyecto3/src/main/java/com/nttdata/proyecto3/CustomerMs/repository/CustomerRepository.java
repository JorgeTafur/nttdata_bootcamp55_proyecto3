package com.nttdata.proyecto3.CustomerMs.repository;

import com.nttdata.proyecto3.CustomerMs.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Optional<Customer> findByDni(String dni);
}
