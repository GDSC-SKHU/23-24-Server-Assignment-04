package gdsc.example.sales.service;

import gdsc.example.sales.domain.Product;
import gdsc.example.sales.dto.ProductDto;
import gdsc.example.sales.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public String createProduct(ProductDto productDto) {
        Product product = createProductData(productDto);
        productRepository.save(product);
        return "저장완료";
    }

    private Product createProductData(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
    }

    public ProductDto findProductByIdAsDto(Integer productId) {
        return findProductById(productId).toDto();
    }

    @Transactional
    public String updateProduct(ProductDto productDto) {
        Product product = findProductById(productDto.getId());
        updateProduct(productDto, product);
        productRepository.save(product);
        return "수정완료";
    }

    private void updateProduct(ProductDto productDto, Product product) {
        product.update(Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build());
    }

    @Transactional
    public String deleteProduct(Integer productId) {
        Product product = findProductById(productId);
        productRepository.delete(product);
        return "삭제완료";
    }

    private Product findProductById(Integer productId) {
        return productRepository.findProductById(productId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 상품 ID입니다."));
    }

}
