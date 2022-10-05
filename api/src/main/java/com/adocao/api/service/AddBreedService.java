package com.adocao.api.service;

import com.adocao.api.controller.request.AddBreedRequest;
import com.adocao.api.domain.Breed;
import com.adocao.api.mapper.AddBreedMapper;
import com.adocao.api.repository.BreedRepository;
import com.adocao.api.validator.AddBreedValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddBreedService {

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private AddBreedValidator addBreedValidator;

    public void addBreed(AddBreedRequest request) {
        addBreedValidator.validate(request);

        Breed breed = AddBreedMapper.toEntity(request);

        breedRepository.save(breed);
    }
}
