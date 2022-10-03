package com.adocao.api.controller.response;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BreedResponse {
    private Long id;
    private Long breedName;
}
