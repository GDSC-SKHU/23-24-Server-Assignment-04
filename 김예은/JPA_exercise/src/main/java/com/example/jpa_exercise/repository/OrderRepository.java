package com.example.jpa_exercise.repository;

import com.example.jpa_exercise.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    Optional<Orders> findOrderByName(String name);
}
