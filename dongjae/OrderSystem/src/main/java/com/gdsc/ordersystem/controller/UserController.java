package com.gdsc.ordersystem.controller;

import com.gdsc.ordersystem.common.dto.ApiResponse;
import com.gdsc.ordersystem.controller.request.UserCreateRequestDto;
import com.gdsc.ordersystem.controller.request.UserNameUpdateDto;
import com.gdsc.ordersystem.controller.request.UserTypeUpdateDto;
import com.gdsc.ordersystem.controller.response.UserDeleteResponseDto;
import com.gdsc.ordersystem.controller.response.UserResponseDto;
import com.gdsc.ordersystem.exception.SuccessCode;
import com.gdsc.ordersystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> createUser(@RequestBody @Valid final UserCreateRequestDto requestDto) {
        final UserResponseDto data = userService.save(requestDto);
        return ApiResponse.success(SuccessCode.CREATE_CUSTOMER_SUCCESS, data);
    }

    @GetMapping("/api/users")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<UserResponseDto>> getUsers() {
        final List<UserResponseDto> data = userService.getUsers();
        return ApiResponse.success(SuccessCode.GET_CUSTOMER_SUCCESS, data);
    }

    @GetMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserResponseDto> getUser(@PathVariable final Long id) {
        final UserResponseDto data = userService.getUser(id);
        return ApiResponse.success(SuccessCode.GET_CUSTOMER_SUCCESS, data);
    }

    @PatchMapping("/api/users/name/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserResponseDto> updateUserName(@PathVariable final Long id, @RequestBody @Valid final UserNameUpdateDto requestDto) {
        final UserResponseDto data = userService.updateUserName(id, requestDto);
        return ApiResponse.success(SuccessCode.UPDATE_CUSTOMER_SUCCESS, data);
    }

    @PatchMapping("/api/users/type/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserResponseDto> updateUserType(@PathVariable final Long id, @RequestBody @Valid final UserTypeUpdateDto requestDto) {
        final UserResponseDto data = userService.updateUserType(id, requestDto);
        return ApiResponse.success(SuccessCode.UPDATE_CUSTOMER_SUCCESS, data);
    }

    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserDeleteResponseDto> deleteUser(@PathVariable final Long id) {
        final UserDeleteResponseDto data = userService.deleteUser(id);
        return ApiResponse.success(SuccessCode.DELETE_SUCCESS, data);
    }

}
