package com.example.jpa_exercise.repository;

import com.example.jpa_exercise.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findOrderByName(String name);
}
