package com.adocao.api.service;

import com.adocao.api.domain.Pet;
import com.adocao.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FindPetByIdService {

    @Autowired
    private PetRepository petRepository;

    public Pet byId(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal não encontrado."));
    }
}
