package com.bank.service;

import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Event;
import com.bank.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventService {
    private final EventRepository eventRepository;

    public Event getById(Long id){
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event with this id not found!"));
    }
}
