package com.adocao.api.service;

import com.adocao.api.controller.request.AddPetRequest;
import com.adocao.api.domain.Pet;
import com.adocao.api.mapper.AddPetMapper;
import com.adocao.api.repository.PetRepository;
import com.adocao.api.validator.AddPetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AddPetValidator addPetValidator;

    public void addPet(AddPetRequest request) {
        addPetValidator.validate(request);
        Pet pet = AddPetMapper.toEntity(request);
        pet.setAvailable(true);
        petRepository.save(pet);
    }
}
