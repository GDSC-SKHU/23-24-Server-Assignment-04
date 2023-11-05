package com.gdsc.productapi_v2.Repositiory;

import com.gdsc.productapi_v2.domain.Product;
import com.gdsc.productapi_v2.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    Optional<Products> findProductByName(String prsName);
}
