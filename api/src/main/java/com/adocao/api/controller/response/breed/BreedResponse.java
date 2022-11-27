package com.adocao.api.controller.response.breed;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BreedResponse {
    private Long id;
    private String breedName;
}
