package com.bank.utils.mappers.impl;

import com.bank.dto.AddressDTO;
import com.bank.models.Address;
import com.bank.utils.mappers.Mappable;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressMapper implements Mappable<Address, AddressDTO> {
    private final ModelMapper modelMapper;
    @Override
    public Address fromDTO(AddressDTO dto) {
        return modelMapper.map(dto, Address.class);
    }

    @Override
    public AddressDTO toDTO(Address entity) {
        return modelMapper.map(entity, AddressDTO.class);
    }

    @Override
    public List<Address> fromDTOs(List<AddressDTO> dtos) {
        return dtos.stream().map(this::fromDTO).toList();
    }

    @Override
    public List<AddressDTO> toDTOs(List<Address> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
}
