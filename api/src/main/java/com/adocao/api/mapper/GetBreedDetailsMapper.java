package com.adocao.api.mapper;

import com.adocao.api.controller.response.GetBreedDetailsResponse;
import com.adocao.api.domain.Breed;

public class GetBreedDetailsMapper {
    public static GetBreedDetailsResponse toResponse(Breed entity) {
        return GetBreedDetailsResponse.builder()
                .id(entity.getId())
                .breedName(entity.getBreedName())
                .build();
    }
}
