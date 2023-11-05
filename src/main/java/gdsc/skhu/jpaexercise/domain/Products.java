package com.gdsc.productapi_v2.domain;
import com.gdsc.productapi_v2.dto.ProductDTO;
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
public class Products {
    @Id @GeneratedValue @Column(name = "PRODUCT_ID" )
    private int id;

    @Column(name="PRODUCT_NAME", nullable = false, insertable=false, updatable=false)  // 사고자 하는 물품 이름
    private String name;

    @Column(name="PRODUCT_COUNT", nullable = false) // 수량
    private int count;


    @OneToMany(mappedBy = "products")
    private List<Orders> orders = new ArrayList<>();  // 참조 변수.


}



