package com.adocao.api.mapper;

import com.adocao.api.controller.request.AddBreedRequest;
import com.adocao.api.domain.Breed;

public class AddBreedMapper {
    public static Breed toEntity(AddBreedRequest request) {
        return Breed.builder()
                .breedName(request.getBreedName())
                .build();
    }
}
