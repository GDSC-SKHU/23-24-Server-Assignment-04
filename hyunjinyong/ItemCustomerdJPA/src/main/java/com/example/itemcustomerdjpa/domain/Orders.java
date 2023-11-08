package com.example.itemcustomerdjpa.domain;

import com.example.itemcustomerdjpa.dto.OrderDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDERS_ID", nullable = false)
    Integer id;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_NAME", nullable = false)
    Customer customer;

    @OneToOne
    @JoinColumn(name = "ITEM_NAME", nullable = false)
    Item item;

    //DTO객체으로 바꾸는 메소드다.
    //customer와 item객체가 null인 경우를 생각해야 한다.
    public OrderDTO toDto(){
        //customer와 item이 null인 아닌 경우, 성공적인 DTO변환이 가능
        if(customer!=null && item!=null){
            return OrderDTO.builder()
                    .id(this.id)
                    .customerName(customer.getName())
                    .itemName(item.getName())
                    .build();
        }
        return null;
    }


    public void update(Orders orders){
        this.id = orders.id;
        this.customer = orders.customer;
        this.item = orders.item;
    }
}
