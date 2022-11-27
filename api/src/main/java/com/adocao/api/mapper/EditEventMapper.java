package com.adocao.api.mapper;

import com.adocao.api.controller.request.EditEventRequest;
import com.adocao.api.domain.Event;

public class EditEventMapper {
    public static Event toEntity(EditEventRequest request) {
        return Event.builder()
                .description(request.getDescription())
                .startEvent(request.getStartEvent())
                .location(request.getLocation())
                .image(request.getImage())
                .build();
    }
}
