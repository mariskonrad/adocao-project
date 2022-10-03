package com.adocao.api.security.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
}
