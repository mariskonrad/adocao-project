package com.adocao.api.mapper.breed;

import com.adocao.api.controller.response.breed.GetBreedDetailsResponse;
import com.adocao.api.domain.Breed;

public class GetBreedDetailsMapper {
    public static GetBreedDetailsResponse toResponse(Breed entity) {
        return GetBreedDetailsResponse.builder()
                .id(entity.getId())
                .breedName(entity.getBreedName())
                .build();
    }
}
