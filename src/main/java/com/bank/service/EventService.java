package com.bank.service;

import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Event;
import com.bank.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findById(Long aLong) {
        return eventRepository.findById(aLong)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Transactional
    public <S extends Event> S save(S entity) {
        return eventRepository.save(entity);
    }

    @Transactional
    public void deleteById(Long aLong) {
        eventRepository.deleteById(aLong);
    }
}
