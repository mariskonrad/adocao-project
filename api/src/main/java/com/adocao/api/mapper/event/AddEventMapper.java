package com.adocao.api.mapper.event;

import com.adocao.api.controller.request.event.AddEventRequest;
import com.adocao.api.domain.Event;

public class AddEventMapper {
    public static Event toEntity(AddEventRequest request) {
        return Event.builder()
                .startEvent(request.getStartEvent())
                .image(request.getImage())
                .description(request.getDescription())
                .location(request.getLocation())
                .build();
    }
}
