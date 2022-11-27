package com.adocao.api.service;

import com.adocao.api.controller.response.event.EventResponse;
import com.adocao.api.domain.Event;
import com.adocao.api.mapper.event.GetEventMapper;
import com.adocao.api.repository.EventRepository;
import com.adocao.api.service.core.FindEventByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetEventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private FindEventByIdService findEventByIdService;

    public EventResponse getEvent(Long id) {
        Event event = findEventByIdService.findEventById(id);

        return GetEventMapper.toResponse(event);
    }
}
