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

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @Column(nullable = false)
    private Long unitPrice;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<OrderDetail> orderDetails;

    @Builder
    public Product(String name, Long unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }
}
