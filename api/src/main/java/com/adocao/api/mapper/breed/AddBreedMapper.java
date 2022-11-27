package com.adocao.api.mapper.breed;

import com.adocao.api.controller.request.breed.AddBreedRequest;
import com.adocao.api.domain.Breed;

public class AddBreedMapper {
    public static Breed toEntity(AddBreedRequest request) {
        return Breed.builder()
                .breedName(request.getBreedName())
                .build();
    }
}
