package com.univstore.headphone.purchasemanagement.repository;

import com.univstore.headphone.purchasemanagement.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findOrderByName(String orderName);
}
