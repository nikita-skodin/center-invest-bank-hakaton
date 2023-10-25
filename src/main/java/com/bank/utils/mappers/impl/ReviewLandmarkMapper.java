package com.bank.utils.mappers.impl;

import com.bank.dto.ReviewLandmarkDTO;
import com.bank.models.ReviewLandmark;
import com.bank.utils.mappers.Mappable;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewLandmarkMapper implements Mappable<ReviewLandmark, ReviewLandmarkDTO> {

    private final ModelMapper modelMapper;

    @Override
    public ReviewLandmark fromDTO(ReviewLandmarkDTO dto) {
        return modelMapper.map(dto, ReviewLandmark.class);
    }

    @Override
    public ReviewLandmarkDTO toDTO(ReviewLandmark entity) {
        return modelMapper.map(entity, ReviewLandmarkDTO.class);
    }

    @Override
    public List<ReviewLandmark> fromDTOs(List<ReviewLandmarkDTO> dtos) {
        return dtos.stream().map(this::fromDTO).toList();
    }

    @Override
    public List<ReviewLandmarkDTO> toDTOs(List<ReviewLandmark> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
}
