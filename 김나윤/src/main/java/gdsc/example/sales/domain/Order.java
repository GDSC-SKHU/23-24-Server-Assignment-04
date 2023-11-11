package gdsc.example.sales.domain;

import gdsc.example.sales.dto.CustomerDto;
import gdsc.example.sales.dto.OrderDto;
import gdsc.example.sales.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "Order_Id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "Cu_Id", nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "Prod_Id", nullable = false)
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    public OrderDto toDto() {
        CustomerDto customerDto = this.customer.toDto();
        ProductDto productDto = this.product.toDto();
        return OrderDto.builder()
                .id(this.id)
                .customer(customerDto)
                .product(productDto)
                .quantity(this.quantity)
                .build();
    }

    public void update(Order order) {
        this.quantity = order.quantity;
    }
}