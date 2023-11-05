package com.gdsc.ordersystem.controller.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDeleteResponseDto {

    Long userId;

    public static UserDeleteResponseDto of(Long userId){
        return new UserDeleteResponseDto(userId);
    }

}
