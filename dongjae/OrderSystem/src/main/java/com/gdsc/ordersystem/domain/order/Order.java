package com.gdsc.ordersystem.domain.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gdsc.ordersystem.domain.BaseEntity;
import com.gdsc.ordersystem.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

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
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<OrderDetail> orderDetails;

    @Builder
    public Order(User user) {
        this.user = user;
    }
}
