package skhu.gdsc.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import skhu.gdsc.jpa.dto.OrderDto;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "ORDER_DATE")
    private String orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    public OrderDto toDto() {
        if(item != null) {
         return OrderDto.builder()
                 .orderId(this.orderId)
                 .orderDate(this.orderDate)
                 .customerId(customer.getCustomerId())
                 .itemId(item.getItemId())
                 .build();
    }
        return OrderDto.builder()
                .orderId(this.orderId)
                .orderDate(this.orderDate)
                .build();
    }

    public void update(Order order) {
        this.orderId = order.orderId;
        if(item != null) {
            changeItem(order.item);
            return;
        }
        this.item = order.item;
    }

    public void changeItem(Item item) {
        this.item = item;
        item.getOrders().add(this);
    }
}
