package com.adocao.api.controller.response.pet;

import com.adocao.api.domain.Breed;
import com.adocao.api.enums.Sex;
import com.adocao.api.enums.Size;
import lombok.*;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class EditPetResponse {
    private Long id;
    private String name;
    private int age;
    private Size size;
    private Sex sex;
    private Breed breed;
    private String image;
    private boolean available;
}
