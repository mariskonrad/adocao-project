package com.adocao.api.controller;

import com.adocao.api.controller.response.EventResponse;
import com.adocao.api.service.ListEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private ListEventService listEventsService;

    @GetMapping()
    public Page<EventResponse> listEvents(Pageable pageable) {
        return listEventsService.listAll(pageable);
    }


}
