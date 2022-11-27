package com.adocao.api.service.event;

import com.adocao.api.controller.request.EditEventRequest;
import com.adocao.api.domain.Event;
import com.adocao.api.repository.EventRepository;
import com.adocao.api.service.core.FindEventByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditEventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private FindEventByIdService findEventByIdService;

    public void edit(Long id, EditEventRequest request) {
        Event event = findEventByIdService.findEventById(id);

        event.setStartEvent(request.getStartEvent());
        event.setId(event.getId());
        event.setDescription(request.getDescription());
        event.setImage(request.getImage());
        event.setLocation(request.getLocation());

        eventRepository.save(event);
    }
}
