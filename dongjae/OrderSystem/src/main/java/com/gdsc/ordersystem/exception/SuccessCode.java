package com.gdsc.ordersystem.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessCode {
    // 200 OK
    GET_CUSTOMER_SUCCESS(HttpStatus.OK, "고객 조회가 완료되었습니다."),
    GET_ITEM_SUCCESS(HttpStatus.OK, "상품 조회가 완료되었습니다."),
    GET_ORDER_SUCCESS(HttpStatus.OK, "주문 조회가 완료되었습니다."),

    UPDATE_CUSTOMER_SUCCESS(HttpStatus.OK, "고객 정보 수정이 완료되었습니다."),
    UPDATE_ITEM_SUCCESS(HttpStatus.OK, "상품 정보 수정이 완료되었습니다."),
    UPDATE_ORDER_SUCCESS(HttpStatus.OK, "주문 정보 수정이 완료되었습니다."),

    // 201 Created
    CREATE_CUSTOMER_SUCCESS(HttpStatus.CREATED, "고객 생성이 완료되었습니다."),
    CREATE_ITEM_SUCCESS(HttpStatus.CREATED, "상품 생성이 완료되었습니다."),
    CREATE_ORDER_SUCCESS(HttpStatus.CREATED, "주문 생성이 완료되었습니다."),

    /**
     * 204 NO CONTENT
     */
    DELETE_SUCCESS(HttpStatus.NO_CONTENT, "삭제가 정상적으로 이루어졌습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
