package com.adocao.api.controller;

import com.adocao.api.controller.request.event.AddEventRequest;
import com.adocao.api.controller.response.event.EventResponse;
import com.adocao.api.service.GetEventService;
import com.adocao.api.service.event.AddEventService;
import com.adocao.api.service.event.ListEventService;
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
}
