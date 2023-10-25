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
    private final AddressMapper addressMapper;
    private final ReviewLandmarkMapper reviewLandmarkMapper;

    @Override
    public Landmark fromDTO(LandmarkDTO dto) {
        Landmark landmark = modelMapper.map(dto, Landmark.class);
        landmark.setAddress(addressMapper.fromDTO(dto.getAddress()));
        return landmark;
    }

    @Override
    public LandmarkDTO toDTO(Landmark entity) {
        LandmarkDTO landmarkDTO = modelMapper.map(entity, LandmarkDTO.class);
        landmarkDTO.setAddress(addressMapper.toDTO(entity.getAddress()));
        landmarkDTO.setReviews(entity.getReviews().stream().map(reviewLandmarkMapper::toDTO).toList());
        return landmarkDTO;
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
