package com.adocao.api.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventResponse {
    private Long id;
    private String description;
    private LocalDateTime startEvent;
    private String location;
    private String image;
}
