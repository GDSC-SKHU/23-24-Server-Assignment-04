package gdsc.example.sales.domain;

import gdsc.example.sales.dto.ProductDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "Prod_Id")
    private Integer id;

    @Column(name = "Prod_Name")
    private String name;

    @Column( name = "Price", nullable = false)
    private Integer price;

    public ProductDto toDto() {
        return ProductDto.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }

    public void update(Product product) {
        this.name = product.name;
        this.price = product.price;
    }

}
