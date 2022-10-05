package com.adocao.api.service;

import com.adocao.api.domain.Pet;
import com.adocao.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private FindPetByIdService findPetByIdService;

    public void delete(Long id) {
        Pet pet = findPetByIdService.byId(id);
        petRepository.deleteById(pet.getId());
    }
}
