package com.adocao.api.service;

import com.adocao.api.domain.Breed;
import com.adocao.api.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteBreedService {

    @Autowired
    private BreedRepository breedRepository;

    public void delete(Long id) {
        Breed breed = breedRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Raça não encontrada."));
        breedRepository.deleteById(breed.getId());
    }
}
