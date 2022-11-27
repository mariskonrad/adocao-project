package com.adocao.api.controller.request.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class AddEventRequest {

    @NotBlank
    private String description;

    @NotNull
    private LocalDateTime startEvent;

    @NotBlank
    private String location;

    @NotBlank
    private String image;
}
