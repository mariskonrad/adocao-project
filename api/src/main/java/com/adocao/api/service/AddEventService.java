package com.adocao.api.service;

import com.adocao.api.controller.request.AddEventRequest;
import com.adocao.api.domain.Event;
import com.adocao.api.mapper.AddEventMapper;
import com.adocao.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddEventService {

    @Autowired
    private EventRepository eventRepository;

    public void add(AddEventRequest request) {
        Event event = AddEventMapper.toEntity(request);

        eventRepository.save(event);
    }
}
