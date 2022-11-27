package com.adocao.api.controller;

import com.adocao.api.controller.request.pet.AddPetRequest;
import com.adocao.api.controller.request.pet.EditPetRequest;
import com.adocao.api.controller.response.pet.EditPetResponse;
import com.adocao.api.controller.response.pet.GetPetsResponse;
import com.adocao.api.controller.response.pet.PetDetailsResponse;
import com.adocao.api.service.pet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private GetAllPetsService petService;

    @Autowired
    private PetDetailsService petDetailsService;

    @Autowired
    private AddPetService addPetService;

    @Autowired
    private DeletePetService deletePetService;

    @Autowired
    private EditPetService editPetService;

    @GetMapping
    public Page<GetPetsResponse> getAllPets(Pageable pageable) {
        return petService.getAllPets(pageable);
    }

    @GetMapping("/{id}")
    public PetDetailsResponse getPetDetails(@PathVariable Long id) {
        return petDetailsService.getPetDetails(id);
    }

    @PostMapping
    public void add(@RequestBody AddPetRequest request) {
        addPetService.addPet(request);
    }

    @PutMapping("/{id}")
    public EditPetResponse editPet(@PathVariable Long id, @RequestBody EditPetRequest request) {
        return editPetService.edit(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deletePetService.delete(id);
    }
}
