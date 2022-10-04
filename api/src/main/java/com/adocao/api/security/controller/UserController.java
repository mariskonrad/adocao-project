package com.adocao.api.security.controller;

import com.adocao.api.security.controller.request.UserRequest;
import com.adocao.api.security.controller.response.UserResponse;
import com.adocao.api.security.service.IncludeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IncludeUserService includeUserService;

    @PostMapping
    public UserResponse include(@RequestBody UserRequest request) {
        return includeUserService.include(request);
    }
}
