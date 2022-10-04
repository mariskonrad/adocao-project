package com.adocao.api.security.controller.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private List<String> permissions;
}
