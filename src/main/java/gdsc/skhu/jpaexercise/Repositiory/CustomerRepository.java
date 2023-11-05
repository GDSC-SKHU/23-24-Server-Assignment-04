package com.gdsc.productapi_v2.Repositiory;

import com.gdsc.productapi_v2.domain.Customer;
import com.gdsc.productapi_v2.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByName(String customerName);
}
