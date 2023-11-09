package com.gdsc.productapi_v2.Controller;

import com.gdsc.productapi_v2.Service.ProductService;
import com.gdsc.productapi_v2.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // 초기화 되지 않은 final필드나, @NonNull이 붙은 필드의 생성자를 자동 생성. / 의존성 주입
public class ProductController {
    private final ProductService productService;

//    public ProductController(ProductService productService){
//        this.productService = productService;
//    } 이 생성자를 @RequiredArgsConstructor가 대신 생성해 주는 것. // final or @NonNull

    @PostMapping("/product/new")
    public String creatProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }
    @GetMapping("/product/{name}")
    public ProductDTO findProduct(@PathVariable String name){
        return productService.findProductByPrDto(name);
    }
    @PutMapping("/product")
    public String updateProduct(@RequestBody ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }
//    @DeleteMapping("/product/{id}")
//    public String deleteProductByName(@PathVariable Long id){
//        return productService.deleteProductById(id);
//    }
    @DeleteMapping("/product")
    public String deleteProduct(@RequestBody ProductDTO productDTO){
        return productService.deleteProduct(productDTO.getName());
    }

}
