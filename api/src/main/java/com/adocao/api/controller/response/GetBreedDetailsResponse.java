package com.adocao.api.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetBreedDetailsResponse {
    private Long id;
    private String breedName;
}
