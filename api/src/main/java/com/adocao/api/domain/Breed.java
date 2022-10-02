package com.adocao.api.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String breedName;

    @OneToMany(mappedBy = "breed")
    private List<Pet> pets = new ArrayList<>();
}
