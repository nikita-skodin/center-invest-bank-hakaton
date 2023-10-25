package com.bank.validators;

import com.bank.dto.UserDTO;
import com.bank.exceptions.InvalidOperationException;
import com.bank.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final UserRepository userRepository;
    public void validate(UserDTO userDTO){
        if (!userDTO.getPassword().equals(userDTO.getPasswordConfiramtion()))
            throw new InvalidOperationException("Password and password confimation doesnt match");
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent())
            throw new InvalidOperationException("User with this username already exists");
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent())
            throw new InvalidOperationException("User with this email already exists");
    }
}
