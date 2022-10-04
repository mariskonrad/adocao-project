package com.adocao.api.controller;

import com.adocao.api.controller.response.GetPetsResponse;
import com.adocao.api.controller.response.PetDetailsResponse;
import com.adocao.api.service.PetDetailsService;
import com.adocao.api.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetDetailsService petDetailsService;

    @GetMapping
    public Page<GetPetsResponse> getAllPets(Pageable pageable) {
        return petService.getAllPets(pageable);
    }

    @GetMapping("pets/{id}")
    public PetDetailsResponse getPetDetails(@PathVariable Long id) {
        return petDetailsService.getPetById(id);
    }
}
