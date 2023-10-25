package com.bank.controllers;

import com.bank.models.ReviewLandmark;
import com.bank.repositories.ReviewLandmarkRepository;
import com.bank.service.ReviewLandmarkService;
import com.bank.utils.mappers.impl.ReviewLandmarkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments/landmarks")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewLandmarkService reviewLandmarkService;
    private final ReviewLandmarkMapper reviewLandmarkMapper;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(reviewLandmarkMapper.toDTOs(reviewLandmarkService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{review_id}")
    public ResponseEntity<Object> getById(@PathVariable("review_id") Long id){
        return new ResponseEntity<>(reviewLandmarkMapper.toDTO(reviewLandmarkService.getById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{review_id}/delete")
    public void deleteById(@PathVariable("review_id") Long id){

    }
}
