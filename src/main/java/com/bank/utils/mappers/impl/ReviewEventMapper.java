package com.bank.utils.mappers.impl;

import com.bank.dto.ReviewEventDTO;
import com.bank.models.ReviewEvent;
import com.bank.service.EventService;
import com.bank.utils.mappers.Mappable;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewEventMapper implements Mappable<ReviewEvent, ReviewEventDTO> {
    private final ModelMapper modelMapper;
    private final EventService eventService;
    @Override
    public ReviewEvent fromDTO(ReviewEventDTO dto) {
        ReviewEvent reviewEvent = modelMapper.map(dto, ReviewEvent.class);
        reviewEvent.setEvent(eventService.getById(dto.getEvent_id()));
        return reviewEvent;
    }

    @Override
    public ReviewEventDTO toDTO(ReviewEvent entity) {
        ReviewEventDTO reviewEventDTO = modelMapper.map(entity, ReviewEventDTO.class);
        reviewEventDTO.setEvent_id(entity.getEvent().getId());
        return reviewEventDTO;
    }

    @Override
    public List<ReviewEvent> fromDTOs(List<ReviewEventDTO> dtos) {
        return dtos.stream().map(this::fromDTO).toList();
    }

    @Override
    public List<ReviewEventDTO> toDTOs(List<ReviewEvent> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
}
