package com.example.itemcustomerdjpa.repository;

import com.example.itemcustomerdjpa.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
