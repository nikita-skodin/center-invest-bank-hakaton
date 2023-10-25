package com.bank.utils.mappers.impl;

import com.bank.dto.UserDTO;
import com.bank.models.User;
import com.bank.utils.mappers.Mappable;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper implements Mappable<User, UserDTO> {
    private final ModelMapper modelMapper;

    @Override
    public User fromDTO(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserDTO toDTO(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public List<User> fromDTOs(List<UserDTO> dtos) {
        return dtos.stream().map(this::fromDTO).toList();
    }

    @Override
    public List<UserDTO> toDTOs(List<User> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
}
