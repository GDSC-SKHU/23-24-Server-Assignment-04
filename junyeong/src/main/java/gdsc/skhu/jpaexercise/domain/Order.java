package gdsc.skhu.jpaexercise.domain;

import gdsc.skhu.jpaexercise.dto.OrderDto;
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
    @Column(name = "ORDER_ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_NAME", nullable = false)
    Customer customer;

    @OneToOne
    @JoinColumn(name = "ITEM_NAME", nullable = false)
    Item item;

    public OrderDto toDto() {
        if (customer != null && item != null) {
            return OrderDto.builder()
                    .id(this.id)
                    .customerName(customer.getName())
                    .itemName(item.getName())
                    .build();
        }
        throw new IllegalArgumentException("주문 정보가 없습니다.");
    }

    public void update(Order order) {
        this.id = order.id;
        this.customer = order.customer;
        this.item = order.item;
    }
}
