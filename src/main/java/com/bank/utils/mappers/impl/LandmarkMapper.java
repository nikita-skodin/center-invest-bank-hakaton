package com.bank.utils.mappers.impl;

import com.bank.dto.LandmarkDTO;
import com.bank.models.Landmark;
import com.bank.utils.mappers.Mappable;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LandmarkMapper implements Mappable<Landmark, LandmarkDTO> {
    private final ModelMapper modelMapper;
    @Override
    public Landmark fromDTO(LandmarkDTO dto) {
        return modelMapper.map(dto, Landmark.class);
    }

    @Override
    public LandmarkDTO toDTO(Landmark entity) {
        return modelMapper.map(entity, LandmarkDTO.class);
    }

    @Override
    public List<Landmark> fromDTOs(List<LandmarkDTO> dtos) {
        return dtos.stream().map(this::fromDTO).toList();
    }

    @Override
    public List<LandmarkDTO> toDTOs(List<Landmark> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
}
