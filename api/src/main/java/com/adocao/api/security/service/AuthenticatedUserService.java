package com.adocao.api.security.service;

import com.adocao.api.security.config.UserSecurity;
import com.adocao.api.security.controller.response.UserResponse;
import com.adocao.api.security.domain.Username;
import com.adocao.api.security.mapper.UserMapper;
import com.adocao.api.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticatedUserService {

    @Autowired
    private UserRepository userRepository;

    public Long getId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserSecurity) {
            return ((UserSecurity) authentication.getPrincipal()).getId();
        }

        return null;
    }

    public Username get() {
        Long id = getId();

        if (Objects.isNull(id)) {
            return null;
        }
        return userRepository.findById(getId()).orElse(null);
    }

    public UserResponse getResponse() {
        Username entity = get();
        return Objects.nonNull(entity) ? UserMapper.toResponse(entity) : new UserResponse();
    }
}
