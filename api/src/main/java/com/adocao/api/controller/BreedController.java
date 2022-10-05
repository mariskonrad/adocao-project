package com.adocao.api.controller;

import com.adocao.api.controller.response.GetAllBreedsResponse;
import com.adocao.api.repository.BreedRepository;
import com.adocao.api.service.GetAllBreedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/breeds")
public class BreedController {

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private GetAllBreedsService getAllBreedsService;

    @GetMapping
    public Page<GetAllBreedsResponse> getAllBreeds(Pageable pageable) {
        return getAllBreedsService.getAllBreeds(pageable);
    }
}
