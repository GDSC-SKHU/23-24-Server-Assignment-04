package com.gdsc.ordersystem.service;

import com.gdsc.ordersystem.controller.request.product.ProductCreateRequestDto;
import com.gdsc.ordersystem.controller.request.product.ProductNameUpdateRequestDto;
import com.gdsc.ordersystem.controller.request.product.ProductUnitPriceUpdateRequestDto;
import com.gdsc.ordersystem.controller.response.product.ProductDeleteResponseDto;
import com.gdsc.ordersystem.controller.response.product.ProductResponseDto;
import com.gdsc.ordersystem.domain.product.Product;
import com.gdsc.ordersystem.exception.ErrorCode;
import com.gdsc.ordersystem.exception.model.BadRequestException;
import com.gdsc.ordersystem.exception.model.NotFoundException;
import com.gdsc.ordersystem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponseDto save(ProductCreateRequestDto requestDto) {

        if (productRepository.existsByName(requestDto.getName())) {
            throw new BadRequestException(ErrorCode.ALREADY_EXIST_PRODUCT_EXCEPTION, ErrorCode.ALREADY_EXIST_PRODUCT_EXCEPTION.getMessage());
        }

        Product product = requestDto.toEntity();
        productRepository.save(product);

        return ProductResponseDto.of(
                product.getId(), product.getName(), product.getUnitPrice(), product.getCreateAt(), product.getUpdateAt()
        );
    }

    @Transactional
    public ProductResponseDto getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION, ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION.getMessage())
        );

        return ProductResponseDto.of(
                product.getId(), product.getName(), product.getUnitPrice(), product.getCreateAt(), product.getUpdateAt()
        );
    }

    @Transactional
    public List<ProductResponseDto> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> result = new ArrayList<>();
        for (Product product : products) {
            result.add(
                ProductResponseDto.of(
                        product.getId(), product.getName(), product.getUnitPrice(), product.getCreateAt(), product.getUpdateAt()
                )
            );
        }

        return result;
    }

    @Transactional
    public ProductResponseDto updateProductName(Long id, ProductNameUpdateRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION, ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION.getMessage())
        );

        product.updateName(requestDto.getName()); // 영속성 컨텍스트로 인해 save 안해도 됨

        return ProductResponseDto.of(
                product.getId(), product.getName(), product.getUnitPrice(), product.getCreateAt(), product.getUpdateAt()
        );
    }

    @Transactional
    public ProductResponseDto updateProductUnitPrice(Long id, ProductUnitPriceUpdateRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION, ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION.getMessage())
        );

        product.updateUnitPrice(requestDto.getUnitPrice()); // 영속성 컨텍스트로 인해 save 안해도 됨

        return ProductResponseDto.of(
                product.getId(), product.getName(), product.getUnitPrice(), product.getCreateAt(), product.getUpdateAt()
        );
    }

    @Transactional
    public ProductDeleteResponseDto deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION, ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION.getMessage())
        );

        productRepository.delete(product);

        return ProductDeleteResponseDto.of(product.getId());
    }

}
