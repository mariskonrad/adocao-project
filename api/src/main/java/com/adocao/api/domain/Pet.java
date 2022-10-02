package com.adocao.api.domain;

import com.adocao.api.enums.Sex;
import com.adocao.api.enums.Size;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private int age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Size size;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "breed_id")
    private Breed breed;

    @NotBlank
    private String image;

    @NotNull
    private boolean available;

    @OneToMany(mappedBy = "pet")
    private List<Comment> comments = new ArrayList<>();
}
