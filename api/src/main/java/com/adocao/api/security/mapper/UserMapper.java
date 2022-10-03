package com.adocao.api.security.mapper;

import com.adocao.api.security.controller.response.UserResponse;
import com.adocao.api.security.domain.Username;

public class UserMapper {

    public static UserResponse toResponse(Username entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
