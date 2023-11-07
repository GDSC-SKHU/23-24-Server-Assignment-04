package com.univstore.headphone.purchasemanagement.repository;

import com.univstore.headphone.purchasemanagement.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByName(String customerName);
}
