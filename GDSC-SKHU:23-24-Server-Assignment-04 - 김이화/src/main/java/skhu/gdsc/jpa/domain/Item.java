package skhu.gdsc.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import skhu.gdsc.jpa.dto.ItemDto;
import skhu.gdsc.jpa.dto.OrderDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Integer itemId;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_PRICE")
    private Integer itemPrice;

    @OneToMany
    @JoinColumn(name = "ITEMS_ORDERS")
    private List<Order> orders = new ArrayList<>();

    public ItemDto toDto() {
        List<OrderDto> orderDtos = orders.stream().map(Order::toDto).toList();
        return ItemDto.builder()
                .itemId(this.itemId)
                .itemName(this.itemName)
                .itemPrice(this.itemPrice)
                .orders(orderDtos)
                .build();
    }

    public  void update(Item item) {
        this.itemId = item.itemId;
        this.itemName = item.itemName;
        this.itemPrice = item.itemPrice;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public Integer getItemId() {
        return this.itemId;
    }
}
