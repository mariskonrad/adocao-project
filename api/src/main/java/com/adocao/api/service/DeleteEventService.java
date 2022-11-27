package com.adocao.api.service;

import com.adocao.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEventService {

    @Autowired
    private EventRepository eventRepository;

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
