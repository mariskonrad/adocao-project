package com.adocao.api.service;

import com.adocao.api.controller.response.PetDetailsResponse;
import com.adocao.api.domain.Pet;
import com.adocao.api.mapper.PetDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class PetDetailsService {

    @Autowired
    private FindPetByIdService findPetByIdService;

    public PetDetailsResponse getPetById(Long id) {
        Pet pet = findPetByIdService.byId(id);

        if (Objects.isNull(pet.isAvailable())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Animal não disponível para adoção.");
        }
        return PetDetailsMapper.toResponse(pet);
    }
}
