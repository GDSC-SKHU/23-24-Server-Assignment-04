package com.gdsc.productapi_v2.domain;
// 상품의 품목에 따른 상품 구매 CRUD API

import com.gdsc.productapi_v2.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id @GeneratedValue @Column(name = "PRODUCT_ID" )
    private int id;

    @Column(name="PRODUCT_NAME", nullable = false, insertable=false, updatable=false)  // 사고자 하는 물품 이름
    private String name;

    @Column(name="PRODUCT_COUNT", nullable = false) // 수량
    private int count;


    @ManyToOne(fetch = FetchType.LAZY)  // 다대일 연관 관계 / 외래키를 가지고 있음으로 연관 관계의 주인
    @JoinColumn(name="PRODUCT_ORDER")
    private Order order;  // 참조 변수.

    public ProductDTO toDto(){
        if(order != null){
            return ProductDTO.builder()
                    .id(this.id)
                    .name(this.name)
                    .count(this.count)
                    .consumer(order.getName())
                    .build();
        }
        return ProductDTO.builder()
                .id(this.id)
                .name(this.name)
                .count(this.count)
                .build();
    }
    public void changeOrder(Order order){  // 다대일 연관관계에선, 외래키를 가지고 있는 곳. 즉, 주인에게서만 값 수정 가능.
        this.order = order;
        order.getProduct().add(this); // getProduct()의 반환값이 리스트이기 때문에, add()를 사용함.
    }
    public void update(Product product){
        this.id = product.id;
        this.name = product.name;
        this.count = product.count;
        if(order != null){
            this.order = order;
            order.getProduct().add(this);
        }
    }
}
