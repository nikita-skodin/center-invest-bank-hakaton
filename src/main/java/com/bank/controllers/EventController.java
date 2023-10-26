package com.bank.controllers;

import com.bank.dto.EventDTO;
import com.bank.models.Event;
import com.bank.service.EventService;
import com.bank.utils.mappers.impl.EventMapper;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    private final static String GET_ALL_EVENTS = "";
    private final static String CREATE_EVENT = "";
    private final static String GET_EVENT_BY_ID = "/{event_id}";
    private final static String DELETE_EVENT_BY_ID = "/{event_id}";
    private final static String UPDATE_EVENT_BY_ID = "/{event_id}";
    @GetMapping(GET_ALL_EVENTS)
    ResponseEntity<List<EventDTO>> getAllEvents(){
        List<Event> events = eventService.findAll();
        return ResponseEntity
                .ok()
                .body(eventMapper.toDTOs(events));
    }

    @GetMapping(GET_EVENT_BY_ID)
    ResponseEntity<EventDTO> getEventById(@PathVariable("event_id") Long id){
        Event events = eventService.findById(id);
        return ResponseEntity
                .ok()
                .body(eventMapper.toDTO(events));
    }

    @PostMapping(CREATE_EVENT)
    ResponseEntity<EventDTO> createEvent(
            @RequestBody
            @Valid EventDTO dto,
            BindingResult bindingResult
            ){

        Event event = eventMapper.fromDTO(dto);
        EventDTO dto1 = eventMapper.toDTO(eventService.save(event));
        return ResponseEntity
                .ok()
                .body(dto1);
    }

    @GetMapping(DELETE_EVENT_BY_ID)
    ResponseEntity<HttpStatus> deleteEventById(@PathVariable("event_id") Long id){
        eventService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
