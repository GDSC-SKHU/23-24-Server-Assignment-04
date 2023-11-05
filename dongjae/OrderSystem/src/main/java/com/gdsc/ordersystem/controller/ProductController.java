package com.gdsc.ordersystem.controller;

import com.gdsc.ordersystem.common.dto.ApiResponse;
import com.gdsc.ordersystem.controller.request.product.ProductCreateRequestDto;
import com.gdsc.ordersystem.controller.request.product.ProductNameUpdateRequestDto;
import com.gdsc.ordersystem.controller.request.product.ProductUnitPriceUpdateRequestDto;
import com.gdsc.ordersystem.controller.response.product.ProductDeleteResponseDto;
import com.gdsc.ordersystem.controller.response.product.ProductResponseDto;
import com.gdsc.ordersystem.exception.SuccessCode;
import com.gdsc.ordersystem.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<com.gdsc.ordersystem.controller.response.product.ProductResponseDto> createUser(@RequestBody @Valid final ProductCreateRequestDto requestDto) {
        final com.gdsc.ordersystem.controller.response.product.ProductResponseDto data = productService.save(requestDto);
        return ApiResponse.success(SuccessCode.CREATE_PRODUCT_SUCCESS, data);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<ProductResponseDto>> getProducts() {
        final List<ProductResponseDto> data = productService.getProducts();
        return ApiResponse.success(SuccessCode.GET_PRODUCT_SUCCESS, data);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<ProductResponseDto> getProduct(@PathVariable final Long id) {
        final ProductResponseDto data = productService.getProduct(id);
        return ApiResponse.success(SuccessCode.GET_PRODUCT_SUCCESS, data);
    }

    @PatchMapping("/name/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<ProductResponseDto> updateProductName(@PathVariable final Long id, @RequestBody @Valid final ProductNameUpdateRequestDto requestDto) {
        final ProductResponseDto data = productService.updateProductName(id, requestDto);
        return ApiResponse.success(SuccessCode.UPDATE_PRODUCT_SUCCESS, data);
    }

    @PatchMapping("/unitPrice/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<ProductResponseDto> updateProductUnitPrice(@PathVariable final Long id, @RequestBody @Valid final ProductUnitPriceUpdateRequestDto requestDto) {
        final ProductResponseDto data = productService.updateProductUnitPrice(id, requestDto);
        return ApiResponse.success(SuccessCode.UPDATE_PRODUCT_SUCCESS, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<ProductDeleteResponseDto> deleteProduct(@PathVariable final Long id) {
        final ProductDeleteResponseDto data = productService.deleteProduct(id);
        return ApiResponse.success(SuccessCode.DELETE_SUCCESS, data);
    }

}
