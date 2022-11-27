package com.adocao.api.mapper.pet;

import com.adocao.api.controller.request.pet.AddPetRequest;
import com.adocao.api.domain.Pet;

public class AddPetMapper {
    public static Pet toEntity(AddPetRequest request) {
        return Pet.builder()
                .name(request.getName())
                .age(request.getAge())
                .size(request.getSize())
                .sex(request.getSex())
                .breed(request.getBreed())
                .image(request.getImage())
                .build();
    }
}
