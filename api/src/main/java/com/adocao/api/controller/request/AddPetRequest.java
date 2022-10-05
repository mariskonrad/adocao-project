package com.adocao.api.controller.request;

import com.adocao.api.domain.Breed;
import com.adocao.api.enums.Sex;
import com.adocao.api.enums.Size;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddPetRequest {
    @NotBlank
    private String name;

    @NotNull
    private int age;

    @NotNull
    private Size size;

    @NotNull
    private Sex sex;

    private Breed breed;

    @NotBlank
    private String image;

}
