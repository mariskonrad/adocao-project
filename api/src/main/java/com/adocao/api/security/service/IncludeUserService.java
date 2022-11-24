package com.adocao.api.security.service;

import com.adocao.api.security.controller.request.UserRequest;
import com.adocao.api.security.controller.response.UserResponse;
import com.adocao.api.security.domain.AccountPermission;
import com.adocao.api.security.domain.UserAccount;
import com.adocao.api.security.mapper.UserMapper;
import com.adocao.api.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IncludeUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse include(UserRequest request) {

        UserAccount user = UserMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);

        if (Objects.isNull(request.getPermissions())) {
            AccountPermission accountPermission = new AccountPermission();
            accountPermission.setRole("ROLE_USUARIO");
            user.addPermission(accountPermission);
        } else {
            request.getPermissions()
                    .forEach(permission -> user.addPermission(AccountPermission.builder().role(permission).build()));
        }

        userRepository.save(user);

        return UserMapper.toResponse(user);
    }
}
