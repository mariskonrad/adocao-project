package com.adocao.api.mapper.breed;

import com.adocao.api.controller.response.breed.GetAllBreedsResponse;
import com.adocao.api.domain.Breed;

public class GetAllBreedsMapper {
    public static GetAllBreedsResponse toResponse(Breed entity) {
        return GetAllBreedsResponse.builder()
                .id(entity.getId())
                .breedName(entity.getBreedName())
                .build();
    }
}
