package com.adocao.api.mapper;

import com.adocao.api.controller.response.PetDetailsResponse;
import com.adocao.api.domain.Pet;

public class PetDetailsMapper {
    public static PetDetailsResponse toResponse(Pet entity) {
        return PetDetailsResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .size(entity.getSize())
                .sex(entity.getSex())
                .breed(entity.getBreed().getId())
                .image(entity.getImage())
                .available(entity.isAvailable())
                .build();
    }
}
