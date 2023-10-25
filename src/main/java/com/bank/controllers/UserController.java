package com.bank.controllers;


import com.bank.service.UserService;
import com.bank.utils.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController extends MainController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{user_id}")
    public ResponseEntity<Object> getUserById(@PathVariable("user_id") Long userId){
        return new ResponseEntity<>(userMapper.toDTO(userService.getById(userId)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userMapper.toDTOs(userService.getAll()), HttpStatus.OK);
    }

}
