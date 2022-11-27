package com.adocao.api.controller.response.breed;

import lombok.*;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class GetAllBreedsResponse {
    private Long id;
    private String breedName;
}
