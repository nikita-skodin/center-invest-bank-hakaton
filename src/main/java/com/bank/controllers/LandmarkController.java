package com.bank.controllers;

import com.bank.dto.LandmarkDTO;
import com.bank.models.Landmark;
import com.bank.service.LandmarkService;
import com.bank.utils.mappers.impl.LandmarkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/landmarks")
@RequiredArgsConstructor
public class LandmarkController extends MainController{

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

    @GetMapping("/{address}")
    public ResponseEntity<Object> getByAddress(@PathVariable ("address")String address){
        return new ResponseEntity<>(landmarkMapper.toDTOs(landmarkService.getAllByAddress(address)),HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Object> save(@RequestBody LandmarkDTO landmark){

        landmarkService.save(landmarkMapper.fromDTO(landmark));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/id/update")
    public ResponseEntity<Object> update(@RequestBody LandmarkDTO landmarkDTO){
        landmarkService.update(landmarkMapper.fromDTO(landmarkDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }








}
