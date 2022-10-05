package com.adocao.api.controller;

import com.adocao.api.controller.response.GetAllBreedsResponse;
import com.adocao.api.controller.response.GetBreedDetailsResponse;
import com.adocao.api.repository.BreedRepository;
import com.adocao.api.service.DeleteBreedService;
import com.adocao.api.service.GetAllBreedsService;
import com.adocao.api.service.GetBreedDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/breeds")
public class BreedController {

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private GetAllBreedsService getAllBreedsService;

    @Autowired
    private GetBreedDetailsService getBreedDetailsService;

    @Autowired
    private DeleteBreedService deleteBreedService;

    @GetMapping
    public Page<GetAllBreedsResponse> getAllBreeds(Pageable pageable) {
        return getAllBreedsService.getAllBreeds(pageable);
    }

    @GetMapping("/{id}")
    public GetBreedDetailsResponse getBreedDetails(@PathVariable Long id) {
        return getBreedDetailsService.getBreed(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBreed(@PathVariable Long id) {
        deleteBreedService.delete(id);
    }
}
