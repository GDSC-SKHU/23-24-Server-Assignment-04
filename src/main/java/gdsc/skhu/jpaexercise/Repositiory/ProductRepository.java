package com.gdsc.productapi_v2.Repositiory;

import com.gdsc.productapi_v2.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> { // <entity 클래스, PK 타입>
    Optional<Product> findProductByName(String prName);
}
