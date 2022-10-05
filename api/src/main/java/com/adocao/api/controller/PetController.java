package com.adocao.api.controller;

import com.adocao.api.controller.request.AddPetRequest;
import com.adocao.api.controller.response.GetPetsResponse;
import com.adocao.api.controller.response.PetDetailsResponse;
import com.adocao.api.service.AddPetService;
import com.adocao.api.service.DeletePetService;
import com.adocao.api.service.PetDetailsService;
import com.adocao.api.service.GetAllPetsService;
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deletePetService.delete(id);
    }
}
