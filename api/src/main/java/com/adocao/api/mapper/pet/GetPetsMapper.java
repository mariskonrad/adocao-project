package com.adocao.api.mapper.pet;

import com.adocao.api.controller.response.pet.GetPetsResponse;
import com.adocao.api.domain.Pet;

public class GetPetsMapper {
    public static GetPetsResponse toResponse(Pet entity) {
        return GetPetsResponse.builder()
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
