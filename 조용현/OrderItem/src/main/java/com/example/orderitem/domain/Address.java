package com.example.orderitem.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
