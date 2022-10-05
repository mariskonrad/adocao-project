package com.adocao.api.repository;

import com.adocao.api.domain.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed, Long> {
}
