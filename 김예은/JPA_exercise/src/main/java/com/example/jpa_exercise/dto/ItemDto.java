package com.example.jpa_exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Integer id;
    private String name;
    private String orderName;

}
