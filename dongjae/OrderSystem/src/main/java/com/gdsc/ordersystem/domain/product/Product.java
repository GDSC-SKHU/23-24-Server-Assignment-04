package com.gdsc.ordersystem.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gdsc.ordersystem.domain.BaseEntity;
import com.gdsc.ordersystem.domain.order.OrderDetail;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Table(name = "PRODUCT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private int unitPrice;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<OrderDetail> orderDetails;

    @Builder
    public Product(String name, int unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

}
