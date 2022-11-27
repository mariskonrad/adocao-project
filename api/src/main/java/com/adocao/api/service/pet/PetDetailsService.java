package com.adocao.api.service.pet;

import com.adocao.api.controller.response.pet.PetDetailsResponse;
import com.adocao.api.domain.Pet;
import com.adocao.api.mapper.pet.PetDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetDetailsService {

    @Autowired
    private FindPetByIdService findPetByIdService;

    public PetDetailsResponse getPetDetails(Long id) {
        Pet pet = findPetByIdService.byId(id);
        return PetDetailsMapper.toResponse(pet);
    }
}
