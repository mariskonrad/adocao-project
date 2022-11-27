package com.adocao.api.controller;

import com.adocao.api.controller.request.EditEventRequest;
import com.adocao.api.controller.request.event.AddEventRequest;
import com.adocao.api.controller.response.event.EventResponse;
import com.adocao.api.service.event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private ListEventService listEventsService;

    @Autowired
    private AddEventService addEventService;

    @Autowired
    private GetEventService getEventService;

    @Autowired
    private DeleteEventService deleteEventService;

    @Autowired
    private EditEventService editEventService;

    @GetMapping()
    public Page<EventResponse> listEvents(Pageable pageable) {
        return listEventsService.listAll(pageable);
    }

    @PostMapping()
    public void createEvent(@RequestBody AddEventRequest request) {
        addEventService.add(request);
    }

    @GetMapping("/{id}")
    public EventResponse getEvent(@PathVariable Long id) {
        return getEventService.getEvent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        deleteEventService.delete(id);
    }

    @PostMapping("/{id}")
    public void editEvent(@RequestBody EditEventRequest request) {
        editEventService.edit(request);

    }
}
