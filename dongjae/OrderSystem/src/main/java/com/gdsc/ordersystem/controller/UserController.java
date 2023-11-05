package com.gdsc.ordersystem.controller;

import com.gdsc.ordersystem.common.dto.ApiResponse;
import com.gdsc.ordersystem.controller.request.user.UserCreateRequestDto;
import com.gdsc.ordersystem.controller.request.user.UserNameUpdateRequestDto;
import com.gdsc.ordersystem.controller.request.user.UserTypeUpdateRequestDto;
import com.gdsc.ordersystem.controller.response.user.UserDeleteResponseDto;
import com.gdsc.ordersystem.controller.response.user.UserResponseDto;
import com.gdsc.ordersystem.exception.SuccessCode;
import com.gdsc.ordersystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> createUser(@RequestBody @Valid final UserCreateRequestDto requestDto) {
        final UserResponseDto data = userService.save(requestDto);
        return ApiResponse.success(SuccessCode.CREATE_CUSTOMER_SUCCESS, data);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<UserResponseDto>> getUsers() {
        final List<UserResponseDto> data = userService.getUsers();
        return ApiResponse.success(SuccessCode.GET_CUSTOMER_SUCCESS, data);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserResponseDto> getUser(@PathVariable final Long id) {
        final UserResponseDto data = userService.getUser(id);
        return ApiResponse.success(SuccessCode.GET_CUSTOMER_SUCCESS, data);
    }

    @PatchMapping("/name/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserResponseDto> updateUserName(@PathVariable final Long id, @RequestBody @Valid final UserNameUpdateRequestDto requestDto) {
        final UserResponseDto data = userService.updateUserName(id, requestDto);
        return ApiResponse.success(SuccessCode.UPDATE_CUSTOMER_SUCCESS, data);
    }

    @PatchMapping("/type/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserResponseDto> updateUserType(@PathVariable final Long id, @RequestBody @Valid final UserTypeUpdateRequestDto requestDto) {
        final UserResponseDto data = userService.updateUserType(id, requestDto);
        return ApiResponse.success(SuccessCode.UPDATE_CUSTOMER_SUCCESS, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserDeleteResponseDto> deleteUser(@PathVariable final Long id) {
        final UserDeleteResponseDto data = userService.deleteUser(id);
        return ApiResponse.success(SuccessCode.DELETE_SUCCESS, data);
    }

}
