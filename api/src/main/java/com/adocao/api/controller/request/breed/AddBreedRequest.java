package com.adocao.api.controller.request.breed;

import lombok.*;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class AddBreedRequest {
    String breedName;
}
