package gdsc.example.sales.controller;

import gdsc.example.sales.dto.ProductDto;
import gdsc.example.sales.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("new")
    public String createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("{id}")
    public ProductDto findProduct(@PathVariable("id") Integer productId) {
        return productService.findProductByIdAsDto(productId);
    }

    @PutMapping
    public String updateProduct(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);
    }

    @DeleteMapping
    public String deleteProduct(@RequestBody ProductDto productDto) {
        return productService.deleteProduct(productDto.getId());
    }
}
