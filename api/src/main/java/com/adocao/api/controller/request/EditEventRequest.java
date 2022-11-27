package com.adocao.api.controller.request;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditEventRequest {
    private String description;
    private LocalDateTime startEvent;
    private String location;
    private String image;
}
