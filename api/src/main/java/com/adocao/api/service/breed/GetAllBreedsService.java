package com.adocao.api.service.breed;

import com.adocao.api.controller.response.breed.GetAllBreedsResponse;
import com.adocao.api.domain.Breed;
import com.adocao.api.mapper.breed.GetAllBreedsMapper;
import com.adocao.api.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetAllBreedsService {

    @Autowired
    private BreedRepository breedRepository;

    public Page<GetAllBreedsResponse> getAllBreeds(Pageable pageable) {
        Page<Breed> breeds = breedRepository.findAll(pageable);
        return breeds.map(breed -> GetAllBreedsMapper.toResponse(breed));
    }
}
