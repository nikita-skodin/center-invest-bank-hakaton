package com.bank.controllers;

import com.bank.dto.UserDTO;
import com.bank.models.User;
import com.bank.security.JWTRequest;
import com.bank.security.JWTResponse;
import com.bank.service.AuthService;
import com.bank.service.UserService;
import com.bank.utils.mappers.impl.UserMapper;
import com.bank.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController extends MainController{
    private final AuthService authService;
    private final UserService userService;
    private final UserValidator userValidator;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public JWTResponse login(@RequestBody JWTRequest jwtRequest){
        return authService.login(jwtRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserDTO userDTO, BindingResult bindingResult){
        userValidator.validate(userDTO, bindingResult);
        checkBindingResult(bindingResult);
        User user = userMapper.fromDTO(userDTO);
        return new ResponseEntity<>(userMapper.toDTO(userService.save(user)), HttpStatus.CREATED);
    }
}
