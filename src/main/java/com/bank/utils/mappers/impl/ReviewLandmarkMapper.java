package com.bank.utils.mappers.impl;

import com.bank.dto.ReviewLandmarkDTO;
import com.bank.models.Landmark;
import com.bank.models.ReviewLandmark;
import com.bank.service.LandmarkService;
import com.bank.utils.mappers.Mappable;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewLandmarkMapper implements Mappable<ReviewLandmark, ReviewLandmarkDTO> {

    private final ModelMapper modelMapper;
    private final LandmarkService landmarkService;

    @Override
    public ReviewLandmark fromDTO(ReviewLandmarkDTO dto) {
        ReviewLandmark reviewLandmark =  modelMapper.map(dto, ReviewLandmark.class);
        reviewLandmark.setLandmark(landmarkService.getById(dto.getLandmark_id()));
        return reviewLandmark;
    }

    @Override
    public ReviewLandmarkDTO toDTO(ReviewLandmark entity) {
        ReviewLandmarkDTO reviewLandmarkDTO = modelMapper.map(entity, ReviewLandmarkDTO.class);
        reviewLandmarkDTO.setLandmark_id(entity.getLandmark().getId());
        return reviewLandmarkDTO;
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
