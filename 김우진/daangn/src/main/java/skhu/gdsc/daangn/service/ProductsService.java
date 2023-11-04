package skhu.gdsc.daangn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skhu.gdsc.daangn.domain.Products;
import skhu.gdsc.daangn.dto.ProductDto;
import skhu.gdsc.daangn.repository.ProductsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public String saveProduct(ProductDto productDto) { //상품 추가(저장)
        Products products = Products.builder()
                .productId(productDto.getProductId())
                .productName(productDto.getProductName())
                .productPrice(productDto.getProductPrice())
                .build();

        productsRepository.save(products);
        return "생성 성공";
    }

    public ProductDto findByproductId(Long productId) { //상품1개 조회
        Products products = productsRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다 " + productId));

        return ProductDto.builder()
                .productId(products.getProductId())
                .productName(products.getProductName())
                .productPrice(products.getProductPrice())
                .build();
    }

    public List<ProductDto> findByAllProducts() { //전체 상품 조회
        return productsRepository.findAll()
                .stream()
                .map(product -> ProductDto.builder()
                        .productId(product.getProductId())
                        .productName(product.getProductName())
                        .productPrice(product.getProductPrice())
                        .build())
                .toList();
    }
}
