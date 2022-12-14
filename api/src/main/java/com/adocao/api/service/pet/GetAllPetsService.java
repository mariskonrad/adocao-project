package com.adocao.api.service.pet;

import com.adocao.api.controller.response.pet.GetPetsResponse;
import com.adocao.api.domain.Pet;
import com.adocao.api.mapper.pet.GetPetsMapper;
import com.adocao.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetAllPetsService {

    @Autowired
    private PetRepository petRepository;

    public Page<GetPetsResponse> getAllPets(Pageable pageable) {
        Page<Pet> pets = petRepository.findAllByAvailable(true, pageable);
        return pets.map(GetPetsMapper::toResponse);
    }
}
