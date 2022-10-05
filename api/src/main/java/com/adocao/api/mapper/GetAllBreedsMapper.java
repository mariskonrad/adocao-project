package com.adocao.api.mapper;

import com.adocao.api.controller.response.GetAllBreedsResponse;
import com.adocao.api.domain.Breed;

public class GetAllBreedsMapper {
    public static GetAllBreedsResponse toResponse(Breed entity) {
        return GetAllBreedsResponse.builder()
                .id(entity.getId())
                .breedName(entity.getBreedName())
                .build();
    }
}
