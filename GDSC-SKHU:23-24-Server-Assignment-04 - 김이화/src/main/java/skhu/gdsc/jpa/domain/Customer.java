package skhu.gdsc.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import skhu.gdsc.jpa.dto.CustomerDto;
import skhu.gdsc.jpa.dto.OrderDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Customer {

    @Id @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private  Integer customerId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_ADDRESS")
    private String customerAddress;

    @OneToMany(mappedBy = "order")
    @Column(name = "CUSTOMER_ORDER")
    private List<Order> orders = new ArrayList<>();

    public CustomerDto toDto() {
        List<OrderDto> orderDtos = orders.stream().map(Order::toDto).toList();
        return CustomerDto.builder()
                .customerId(this.customerId)
                .customerName(this.customerName)
                .customerAddress(this.customerAddress)
                .orders(orderDtos)
                .build();
    }

    public void update(Customer customer) {
        this.customerId = customer.customerId;
        this.customerName = customer.customerName;
        this.customerAddress = customer.customerAddress;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public Integer getCustomerId() {
        return this.customerId;
    }
}
