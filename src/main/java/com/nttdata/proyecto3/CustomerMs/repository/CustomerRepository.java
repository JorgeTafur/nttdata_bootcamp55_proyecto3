package com.nttdata.proyecto3.CustomerMs.repository;

import com.nttdata.proyecto3.CustomerMs.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
