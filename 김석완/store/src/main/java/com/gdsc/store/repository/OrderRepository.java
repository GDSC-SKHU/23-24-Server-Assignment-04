package com.gdsc.store.repository;

import com.gdsc.store.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findOrderById(int orderId);
}
