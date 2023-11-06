package com.gdsc.ordersystem.repository;

import com.gdsc.ordersystem.domain.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
