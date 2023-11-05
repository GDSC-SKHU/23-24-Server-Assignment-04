package com.gdsc.productapi_v2.domain;

import com.gdsc.productapi_v2.dto.OrderDTO;
import com.gdsc.productapi_v2.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderProduct")
public class Order {
    @Id @GeneratedValue @Column(name = "ORDER_ID") // @ID는 PK / @GeneratedValue = 키 자동 증가 / @Column = 열을 의미
    private int id;

    @Column(name = "ORDER_NAME", nullable = false)  // consumer name / 주문자 이름
    private String name;

    @OneToMany(mappedBy = "order")  // Product클래스에서 order를 참조 변수로 사용하였기 때문에, order로 매핑함.
    @Column(name = "ORDER_LIST")   // 양방향 연관 관계는 사실 단방향이 쌍으로 이뤄진 것.
    private List<Product> orderList = new ArrayList<>();

    public OrderDTO toDto(){
        List<ProductDTO> productDtos = orderList.stream().map(Product::toDto).toList(); // ProductDTO의 products필드를 위한.
        return OrderDTO.builder()
                .id(this.id)
                .ordername(this.name)
                .products(productDtos)
                .build();
    }

    public String getName(){ // 연관 관계의 주인이 아니기 때문에, 조회만 가능
        return this.name;
    }
    public List<Product> getProduct(){  // 반환값 : 리스트
        return Collections.unmodifiableList(orderList); // unmodifiableList = 리스트에 데이터를 추가한 뒤 더이상 데이터 삭제, 추가를 못하게 막는 메소드.
    }

    public void update(Order order){
        this.id = id;
        this.name = name;
    }

}
