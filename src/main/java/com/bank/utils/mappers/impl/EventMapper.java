package com.bank.utils.mappers.impl;

import com.bank.dto.EventDTO;
import com.bank.models.Event;
import com.bank.service.EventService;
import com.bank.utils.mappers.Mappable;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventMapper implements Mappable<Event, EventDTO> {
    private final ModelMapper modelMapper;
    private final EventService eventService;
    @Override
    public Event fromDTO(EventDTO dto) {
        return modelMapper.map(dto, Event.class);
    }

    @Override
    public EventDTO toDTO(Event entity) {
        return modelMapper.map(entity, EventDTO.class);
    }

    @Override
    public List<Event> fromDTOs(List<EventDTO> dtos) {
        return dtos.stream().map(o -> modelMapper.map(o, Event.class)).collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> toDTOs(List<Event> entities) {
        return entities.stream().map(o -> modelMapper.map(o, EventDTO.class)).collect(Collectors.toList());
    }
}
