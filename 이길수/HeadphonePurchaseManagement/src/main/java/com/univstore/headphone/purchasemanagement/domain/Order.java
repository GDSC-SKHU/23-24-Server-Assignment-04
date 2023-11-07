package com.univstore.headphone.purchasemanagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.univstore.headphone.purchasemanagement.dto.OrderDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Integer id;

    @Column(name = "ORDER_NAME", nullable = false)
    private String name;

    @Column(name = "ORDERAMOUNT", nullable = false)
    private Integer amount;

    @Column(name = "ORDERDATE", nullable = false)
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HEADPHONE_ID")
    private Headphone headphone;

    public OrderDto toCustomerDto() {
        if (customer != null) {
            return OrderDto.builder()
                    .id(this.id)
                    .name(this.name)
                    .amount(this.amount)
                    .date(this.date)
                    .customerName(customer.getName())
                    .build();
        }
        return OrderDto.builder()
                .id(this.id)
                .name(this.name)
                .amount(this.amount)
                .date(this.date)
                .build();
    }

    public OrderDto toHeadphoneDto() {
        if (headphone != null) {
            return OrderDto.builder()
                    .id(this.id)
                    .name(this.name)
                    .amount(this.amount)
                    .date(this.date)
                    .headphoneName(headphone.getName())
                    .build();
        }
        return OrderDto.builder()
                .id(this.id)
                .name(this.name)
                .amount(this.amount)
                .date(this.date)
                .build();
    }

    public void customerUpdate(Order order) {
        this.id = order.id;
        this.name = order.name;
        this.amount = order.amount;
        this.date = order.date;
        if (customer != null) {
            changeCustomer(order.customer);
            return;
        }
        this.customer = order.customer;
    }

    public void headphoneUpdate(Order order) {
        this.id = order.id;
        this.name = order.name;
        this.amount = order.amount;
        this.date = order.date;
        if (headphone != null) {
            changeHeadphone(order.headphone);
            return;
        }
        this.headphone = order.headphone;
    }

    public void changeCustomer(Customer customer) {
        this.customer = customer;
        customer.getOrders().add(this);
    }

    public void changeHeadphone(Headphone headphone) {
        this.headphone = headphone;
        headphone.getOrders().add(this);
    }
}
