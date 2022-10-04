package com.adocao.api.security.controller;

import com.adocao.api.security.controller.response.UserResponse;
import com.adocao.api.security.service.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SearchUserService searchUserService;

    @PostMapping
    public UserResponse login() {
        return searchUserService.search();
    }
}
