package skhu.gdsc.daangn.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skhu.gdsc.daangn.dto.CustomerDto;
import skhu.gdsc.daangn.dto.ProductDto;
import skhu.gdsc.daangn.service.ProductsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductsController {
    private final ProductsService productsService;

    @PostMapping("/newProduct") //상품 정보 입력
    public String saveNewProduct(@RequestBody ProductDto productDto){
        return productsService.saveProduct(productDto);
    }

    @GetMapping("/{productId}") //상품 조회
    public ProductDto findProduct(@PathVariable("productId") Long productId){
        return productsService.findByproductId(productId);
    }

    @GetMapping("/All") //전체 상품 조회
    public List<ProductDto> findAllProduct(){
        return productsService.findByAllProducts();
    }

}
