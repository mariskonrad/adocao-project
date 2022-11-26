package com.adocao.api.controller;

import com.adocao.api.controller.request.AddEventRequest;
import com.adocao.api.controller.response.EventResponse;
import com.adocao.api.service.AddEventService;
import com.adocao.api.service.ListEventService;
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

    @GetMapping()
    public Page<EventResponse> listEvents(Pageable pageable) {
        return listEventsService.listAll(pageable);
    }

    @PostMapping()
    public void createEvent(@RequestBody AddEventRequest request) {
        addEventService.add(request);
    }
}
