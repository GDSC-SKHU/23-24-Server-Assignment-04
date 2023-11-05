package com.gdsc.productapi_v2.dto;

import com.gdsc.productapi_v2.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor   //
public class OrderDTO {
    private Integer id;
    private String ordername;  // 구매자
    private List<ProductDTO> products = new ArrayList<>(); // 상품을 조회하기 위한 리스트 컬렉션
}
