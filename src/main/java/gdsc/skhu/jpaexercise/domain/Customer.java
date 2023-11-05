package com.gdsc.productapi_v2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "`CUSTOMER_ID") // @ID는 PK / @GeneratedValue = 키 자동 증가 / @Column = 열을 의미
    private int id;

    @Column(name = "CUSTOMER_NAME", nullable = false)  // consumer name / 주문자 이름
    private String name;

    @OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();

    public String getName(){
        return this.name;
    }
}
