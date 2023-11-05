package com.gdsc.productapi_v2.Service;

import com.gdsc.productapi_v2.Repositiory.ProductRepository;
import com.gdsc.productapi_v2.domain.Order;
import com.gdsc.productapi_v2.domain.Product;
import com.gdsc.productapi_v2.dto.ProductDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final OrderService orderService;

    //CREATE
    @Transactional // 메서드 실행 중 예외가 발생하면, 스프링은 트랜잭션을 롤백하여 이전 상태로 되돌린다.
    public String createProduct(ProductDTO productDTO){
        if(productDTO.getConsumer() == null){
            Product product = createProductWithoutConsumer(productDTO);
            productRepository.save(product);
            return "저장 성공!";
        }
        else{
            Product product = createProductWithConsumer(productDTO);
            productRepository.save(product);
            return "저장 성공!";
        }
    }
    private Product createProductWithoutConsumer(ProductDTO productDTO){
        return Product.builder()
                .name(productDTO.getName())
                .count(productDTO.getCount())
                .build();
    }
    private Product createProductWithConsumer(ProductDTO productDTO){
        Order order = findOrderByName(productDTO.getConsumer());
        return Product.builder()
                .name(productDTO.getName())
                .count(productDTO.getCount())
                .order(order)
                .build();
    }

    // READ
    public ProductDTO findProductByPrDto(String name){
        return findProductByName(name).toDto();
    }

    // UPDATE
    public String updateProduct(ProductDTO productDTO){
        Product product = findProductByName(productDTO.getName());
        if (productDTO.getConsumer() == null){
            updateProductWithoutOrder(productDTO, product);
            productRepository.save(product);
            return "수정 성공";
        }
        else {
            updateProductWithOrder(productDTO,product);
            productRepository.save(product);
            return "수정 성공";
        }
    }
    public void updateProductWithoutOrder(ProductDTO productDTO, Product product){
        product.update(Product.builder()
                .id((productDTO.getId()))
                .name(productDTO.getName())
                .count(productDTO.getCount())
                .build());
    }
    public void updateProductWithOrder(ProductDTO productDTO, Product product){
        Order order = orderService.findOrderByName(productDTO.getName());
        product.update(Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .count(productDTO.getCount())
                .order(order)
                .build());
    }
    // DELETE
    @Transactional
    public String deleteProduct(String prName){
        Product product = findProductByName(prName);
        productRepository.delete(product);
        return "삭제 완료";
    }
    public Product findProductByName(String name){
        return productRepository.findProductByName(name)
                .orElseThrow(()->new IllegalArgumentException("잘못된 이름"));
    }
    public Order findOrderByName(String name){
        return orderService.findOrderByName(name);
    }
//    public String deleteProductById(Long id){
////        Product product = findProductByName(name);
//        productRepository.deleteById(id);
//        return "삭제 완료";
//    }
}
