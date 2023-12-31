package com.gdsc.ordersystem.domain.order;

import com.gdsc.ordersystem.domain.BaseEntity;
import com.gdsc.ordersystem.domain.product.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "ORDER_DETAIL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail extends BaseEntity {

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Builder
    public OrderDetail(Long quantity, Product product, Order order) {
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
