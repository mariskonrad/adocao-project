package com.adocao.api.security.service;

import com.adocao.api.security.controller.response.UserResponse;
import com.adocao.api.security.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.adocao.api.security.mapper.UserMapper.toResponse;

@Service
public class SearchUserService {
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public UserResponse search() {
        UserAccount usuarioAutenticado = authenticatedUserService.get();
        return toResponse(usuarioAutenticado);
    }
}
