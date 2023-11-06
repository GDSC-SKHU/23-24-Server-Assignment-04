package com.gdsc.ordersystem.repository;

import com.gdsc.ordersystem.domain.order.Order;
import com.gdsc.ordersystem.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
