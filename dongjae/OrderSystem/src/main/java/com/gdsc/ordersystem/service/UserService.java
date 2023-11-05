package com.gdsc.ordersystem.service;

import com.gdsc.ordersystem.controller.request.user.UserCreateRequestDto;
import com.gdsc.ordersystem.controller.request.user.UserNameUpdateDto;
import com.gdsc.ordersystem.controller.request.user.UserTypeUpdateDto;
import com.gdsc.ordersystem.controller.response.user.UserDeleteResponseDto;
import com.gdsc.ordersystem.controller.response.user.UserResponseDto;
import com.gdsc.ordersystem.domain.user.User;
import com.gdsc.ordersystem.exception.ErrorCode;
import com.gdsc.ordersystem.exception.model.BadRequestException;
import com.gdsc.ordersystem.exception.model.NotFoundException;
import com.gdsc.ordersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(UserCreateRequestDto requestDto) {

        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new BadRequestException(ErrorCode.ALREADY_EXIST_EMAIL_EXCEPTION, ErrorCode.ALREADY_EXIST_EMAIL_EXCEPTION.getMessage());
        }

        User user = requestDto.toEntity();

        userRepository.save(user);

        return UserResponseDto.of(
                user.getId(), user.getName(), user.getEmail(), user.getUserType(), user.getCreateAt(), user.getUpdateAt()
        );
    }

    @Transactional
    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_USER_EXCEPTION, ErrorCode.NOT_FOUND_USER_EXCEPTION.getMessage())
        );

        return UserResponseDto.of(
                user.getId(), user.getName(), user.getEmail(), user.getUserType(), user.getCreateAt(), user.getUpdateAt()
        );
    }

    @Transactional
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> result = new ArrayList<>();
        for (User user : users) {
            result.add(
                    UserResponseDto.of(
                            user.getId(), user.getName(), user.getEmail(), user.getUserType(), user.getCreateAt(), user.getUpdateAt()
                    )
            );
        }

        return result;
    }

    @Transactional
    public UserResponseDto updateUserName(Long id, UserNameUpdateDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_USER_EXCEPTION, ErrorCode.NOT_FOUND_USER_EXCEPTION.getMessage())
        );

        user.updateName(requestDto.getName()); // 영속성 컨텍스트로 인해 save 안해도 됨

        return UserResponseDto.of(
                user.getId(), user.getName(), user.getEmail(), user.getUserType(), user.getCreateAt(), user.getUpdateAt()
        );
    }

    @Transactional
    public UserResponseDto updateUserType(Long id, UserTypeUpdateDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_USER_EXCEPTION, ErrorCode.NOT_FOUND_USER_EXCEPTION.getMessage())
        );

        user.updateUserType(requestDto.getUserType()); // 영속성 컨텍스트로 인해 save 안해도 됨

        return UserResponseDto.of(
                user.getId(), user.getName(), user.getEmail(), user.getUserType(), user.getCreateAt(), user.getUpdateAt()
        );
    }

    @Transactional
    public UserDeleteResponseDto deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_USER_EXCEPTION, ErrorCode.NOT_FOUND_USER_EXCEPTION.getMessage())
        );

        userRepository.delete(user);

        return UserDeleteResponseDto.of(user.getId());
    }
}
