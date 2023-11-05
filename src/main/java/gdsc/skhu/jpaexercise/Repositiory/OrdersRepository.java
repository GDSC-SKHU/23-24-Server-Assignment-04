package com.gdsc.productapi_v2.Repositiory;

import com.gdsc.productapi_v2.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
