package com.bank.controllers;


import com.bank.service.UserService;
import com.bank.utils.mappers.impl.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User controller", description = "User API")
public class UserController extends MainController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "Get user by ID")
    @GetMapping("/{user_id}")
    public ResponseEntity<Object> getUserById(@PathVariable("user_id") Long userId){
        return new ResponseEntity<>(userMapper.toDTO(userService.getById(userId)), HttpStatus.OK);
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userMapper.toDTOs(userService.getAll()), HttpStatus.OK);
    }

}
