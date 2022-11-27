package com.adocao.api.mapper.event;

import com.adocao.api.controller.response.event.EventResponse;
import com.adocao.api.domain.Event;

public class GetEventMapper {
    public static EventResponse toResponse(Event entity) {
        return EventResponse.builder()
                .id(entity.getId())
                .image(entity.getImage())
                .startEvent(entity.getStartEvent())
                .description(entity.getDescription())
                .location(entity.getLocation())
                .build();
    }
}
