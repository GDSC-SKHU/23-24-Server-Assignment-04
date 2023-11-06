package com.gdsc.ordersystem.domain.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gdsc.ordersystem.domain.BaseEntity;
import com.gdsc.ordersystem.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "TBL_ORDER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderDetail> orderDetails = new ArrayList<>();

    @Builder
    public Order(User user) {
        this.user = user;
    }

    // 주문 상세(OrderDetail)를 추가하는 메소드
    public void addOrderDetail(OrderDetail orderDetail) {
        this.orderDetails.add(orderDetail);
        orderDetail.setOrder(this); // 주문 상세에도 주문을 설정
    }

}
