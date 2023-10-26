package com.bank.service;

import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Event;
import com.bank.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getAll() {
        eventRepository.deleteAllByStartTimeAfter(Instant.now());
        return eventRepository.findAll();
    }

    public Event getById(Long aLong) {
        return eventRepository.findById(aLong)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public Optional<Event> getEventByTitle(String title) {
        return eventRepository.findEventByTitle(title);
    }

    @Transactional
    public Event update(Long id, Event entity) {
        Event event = getById(id);

        entity.setId(event.getId());

        return eventRepository.save(entity);
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
