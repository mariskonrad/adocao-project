package com.adocao.api.controller.response;

import com.adocao.api.enums.Sex;
import com.adocao.api.enums.Size;
import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class GetPetsResponse {
    private Long id;
    private String name;
    private int age;
    private Size size;
    private Sex sex;
    private Long breed;
    private String image;
    private boolean available;
}
