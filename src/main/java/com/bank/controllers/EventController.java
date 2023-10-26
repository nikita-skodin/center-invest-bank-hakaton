package com.bank.controllers;

import com.bank.dto.EventDTO;
import com.bank.models.Event;
import com.bank.service.EventService;
import com.bank.utils.mappers.impl.EventMapper;
import com.bank.validators.EventDTOValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
@Tag(name = "Event Controller", description = "Event API")
public class EventController extends MainController {

    private final EventService eventService;
    private final EventMapper eventMapper;
    private final EventDTOValidator eventDTOValidator;

    private final static String GET_ALL_EVENTS = "";
    private final static String CREATE_EVENT = "";
    private final static String GET_EVENT_BY_ID = "/{event_id}";
    private final static String DELETE_EVENT_BY_ID = "/{event_id}";
    private final static String UPDATE_EVENT_BY_ID = "/{event_id}";

    @Operation(summary = "Get all events")
    @GetMapping(GET_ALL_EVENTS)
    ResponseEntity<List<EventDTO>> getAllEvents(
            @RequestParam(required = false) Optional<String> prefix,
            @RequestParam(required = false) Optional<Integer> limit){
        List<Event> events;

        if (prefix.isPresent()) {
            events = eventService.findAllByTitleStartingWith(prefix.get().trim()); // вместо проверки просто trim
        } else {
            events = eventService.getAll();
        }

        if (limit.isPresent() && limit.get()>events.size()){
            limit = Optional.of(events.size());
        }

        return ResponseEntity
                .ok()
                .body(eventMapper.toDTOs(events).subList(0, limit.orElse(events.size())));
    }

    @Operation(summary = "Get event by id")
    @GetMapping(GET_EVENT_BY_ID)
    ResponseEntity<EventDTO> getEventById(@PathVariable("event_id") Long id){
        Event events = eventService.getById(id);
        return ResponseEntity
                .ok()
                .body(eventMapper.toDTO(events));
    }

    @Operation(summary = "Create new event")
    @PostMapping(CREATE_EVENT)
    ResponseEntity<EventDTO> createEvent(
            @RequestBody
            @Valid EventDTO dto,
            BindingResult bindingResult){

        eventDTOValidator.validate(dto, bindingResult);

        checkBindingResult(bindingResult);

        Event event = eventMapper.fromDTO(dto);
        EventDTO dto1 = eventMapper.toDTO(eventService.save(event));
        return ResponseEntity
                .ok()
                .body(dto1);
    }

    @Operation(summary = "Update event")
    @PatchMapping(UPDATE_EVENT_BY_ID)
    ResponseEntity<EventDTO> updateEvent(
            @RequestBody
            @Valid EventDTO dto,
            BindingResult bindingResult,
            @PathVariable("event_id") Long eventId){

        eventDTOValidator.validate(dto, bindingResult);

        checkBindingResult(bindingResult);

        Event event = eventMapper.fromDTO(dto);
        EventDTO dto1 = eventMapper.toDTO(eventService.update(eventId, event));
        return ResponseEntity
                .ok()
                .body(dto1);
    }

    @Operation(summary = "Delete event by id")
    @DeleteMapping(DELETE_EVENT_BY_ID)
    ResponseEntity<HttpStatus> deleteEventById(@PathVariable("event_id") Long id){
        eventService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
