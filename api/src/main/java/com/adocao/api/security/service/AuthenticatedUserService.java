package com.adocao.api.security.service;

import com.adocao.api.security.config.UserSecurity;
import com.adocao.api.security.controller.response.UserResponse;
import com.adocao.api.security.domain.UserAccount;
import com.adocao.api.security.mapper.UserMapper;
import com.adocao.api.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class AuthenticatedUserService {

    @Autowired
    private UserRepository userRepository;

    public Long getId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserSecurity userSecurity = (UserSecurity) authentication.getPrincipal();
        return userSecurity.getId();
    }

    public UserAccount get() {
        return userRepository.findById(getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Usuário não existe ou não está autenticado."));
    }

    public UserResponse getResponse() {
        UserAccount entity = get();
        return Objects.nonNull(entity) ? UserMapper.toResponse(entity) : new UserResponse();
    }
}
