package com.gdsc.ordersystem.repository;

import com.gdsc.ordersystem.domain.product.Product;
import com.gdsc.ordersystem.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
}
