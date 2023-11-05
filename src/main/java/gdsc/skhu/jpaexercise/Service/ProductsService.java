package com.gdsc.productapi_v2.Service;

import com.gdsc.productapi_v2.Repositiory.ProductRepository;
import com.gdsc.productapi_v2.domain.Product;
import com.gdsc.productapi_v2.dto.ProductDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductRepository productRepository;

    // 상품 생성
    @Transactional
    public String createProducts(ProductDTO productDTO){
        Product product = Product.builder()
                .name(productDTO.getName())
                .count(productDTO.getCount())
                .build();
        return "상품 생성";
    }

    // 상품 조회(이름으로)
    @Transactional
    public ProductDTO findProductsByName(String name){
        return productRepository.findProductByName(name);
    }

    // 상품 삭제
    @Transactional
    public String deleteProducts(ProductDTO productDTO){
        Product product = findProductsByName(productDTO.getName());
        produc

    }
}
