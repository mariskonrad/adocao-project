package com.adocao.api.service.breed;

import com.adocao.api.controller.response.breed.GetBreedDetailsResponse;
import com.adocao.api.domain.Breed;
import com.adocao.api.mapper.breed.GetBreedDetailsMapper;
import com.adocao.api.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetBreedDetailsService {

    @Autowired
    private BreedRepository breedRepository;

    public GetBreedDetailsResponse getBreed(Long id) {
        Breed breed = breedRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Raça não encontrada."));

        GetBreedDetailsResponse response = GetBreedDetailsMapper.toResponse(breed);
        return response;
    }
}
