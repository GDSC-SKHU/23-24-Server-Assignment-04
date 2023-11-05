package com.gdsc.ordersystem.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gdsc.ordersystem.domain.BaseEntity;
import com.gdsc.ordersystem.domain.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Table(name = "USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Order> orders;

    @Builder
    public User(String name, String email, UserType userType) {
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateUserType(UserType userType) {
        this.userType = userType;
    }
}
