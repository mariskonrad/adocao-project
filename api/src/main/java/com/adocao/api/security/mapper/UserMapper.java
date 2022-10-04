package com.adocao.api.security.mapper;

import com.adocao.api.security.controller.request.UserRequest;
import com.adocao.api.security.controller.response.UserResponse;
import com.adocao.api.security.domain.AccountPermission;
import com.adocao.api.security.domain.UserAccount;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UserMapper {

    public static UserResponse toResponse(UserAccount entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .permissions(buildPermissionsResponse(entity.getPermissions()))
                .build();
    }

    public static UserAccount toEntity(UserRequest request) {
        UserAccount entity = new UserAccount();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        return entity;
    }

    private static List<String> buildPermissionsResponse(List<AccountPermission> permissions) {
        return permissions.stream()
                .map(AccountPermission::getRole)
                .collect(toList());
    }
}
