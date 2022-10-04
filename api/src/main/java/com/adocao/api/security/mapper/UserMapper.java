package com.adocao.api.security.mapper;

import com.adocao.api.security.controller.request.UserRequest;
import com.adocao.api.security.controller.response.UserResponse;
import com.adocao.api.security.domain.UserAccount;

public class UserMapper {

    public static UserResponse toResponse(UserAccount entity) {
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        return response;
    }

    public static UserAccount toEntity(UserRequest request) {
        UserAccount entity = new UserAccount();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        return entity;
    }
}
