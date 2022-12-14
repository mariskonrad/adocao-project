package com.adocao.api.service.event;

import com.adocao.api.controller.response.event.EventResponse;
import com.adocao.api.domain.Event;
import com.adocao.api.mapper.event.GetAllEventsMapper;
import com.adocao.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class ListEventService {

    @Autowired
    private EventRepository eventRepository;

    public Page<EventResponse> listAll(Pageable pageable) {
        Page<Event> events = eventRepository.findAll(pageable);
        return events.map(GetAllEventsMapper::toResponse);
    }
}
