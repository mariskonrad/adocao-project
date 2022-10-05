package com.adocao.api.service;

import com.adocao.api.controller.request.EditPetRequest;
import com.adocao.api.controller.response.EditPetResponse;
import com.adocao.api.domain.Pet;
import com.adocao.api.mapper.EditPetMapper;
import com.adocao.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditPetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private FindPetByIdService findPetByIdService;

    public EditPetResponse edit(Long id, EditPetRequest request) {
        Pet pet = findPetByIdService.byId(id);

        pet.setName(request.getName());
        pet.setAge(request.getAge());
        pet.setSize(request.getSize());
        pet.setSex(request.getSex());
        pet.setBreed(request.getBreed());
        pet.setImage(request.getImage());

        petRepository.save(pet);

        return EditPetMapper.toResponse(pet);
    }
}
