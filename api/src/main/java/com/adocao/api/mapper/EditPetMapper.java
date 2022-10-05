package com.adocao.api.mapper;

import com.adocao.api.controller.response.EditPetResponse;
import com.adocao.api.domain.Pet;

public class EditPetMapper {
    public static EditPetResponse toResponse(Pet entity) {
        return EditPetResponse.builder()
                .name(entity.getName())
                .age(entity.getAge())
                .size(entity.getSize())
                .sex(entity.getSex())
                .breed(entity.getBreed())
                .image(entity.getImage())
                .build();
    }
}
