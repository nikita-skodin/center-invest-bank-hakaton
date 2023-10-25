package com.bank.service;

import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Role;
import com.bank.models.User;
import com.bank.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User whit this id not found!"));
    }

    public User getByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent())
            return user.get();
        System.out.println("User with this username not found!");
        return null;
    }

    @Transactional
    public User save(User user){
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new IllegalStateException("User with this username already exists");
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new IllegalStateException("User with this email already exists");
        user.setRoles(new HashSet<>(List.of(Role.ROLE_USER)));
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
