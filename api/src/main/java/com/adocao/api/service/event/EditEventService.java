package com.adocao.api.service.event;

import com.adocao.api.controller.request.EditEventRequest;
import com.adocao.api.domain.Event;
import com.adocao.api.mapper.EditEventMapper;
import com.adocao.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditEventService {

    @Autowired
    private EventRepository eventRepository;

    public void edit(EditEventRequest request) {
        Event event = EditEventMapper.toEntity(request);

        eventRepository.save(event);
    }
}
