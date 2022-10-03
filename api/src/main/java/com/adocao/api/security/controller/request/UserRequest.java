package com.adocao.api.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserRequest {

    @NotBlank
    private String name;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String password;
}
