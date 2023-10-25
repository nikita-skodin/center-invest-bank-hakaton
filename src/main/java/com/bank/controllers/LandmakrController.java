package com.bank.controllers;

import com.bank.models.Landmark;
import com.bank.service.LandmarkService;
import com.bank.utils.mappers.impl.LandmarkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/landmarks")
@RequiredArgsConstructor
public class LandmakrController extends MainController{

    private final LandmarkService landmarkService;
    private final LandmarkMapper landmarkMapper;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(landmarkMapper.toDTOs(landmarkService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{landmark_id}")
    public ResponseEntity<Object> getById(
            @PathVariable("landmark_id") Long id){
        return new ResponseEntity<>(landmarkMapper.toDTO(landmarkService.getById(id)), HttpStatus.OK);
    }
}
