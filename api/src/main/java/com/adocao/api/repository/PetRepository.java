package com.adocao.api.repository;

import com.adocao.api.domain.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Page<Pet> findAllByAvailable(boolean available, Pageable pageable);
}
