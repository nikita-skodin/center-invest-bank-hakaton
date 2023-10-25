package com.bank.controllers;

import com.bank.dto.ReviewEventDTO;
import com.bank.models.ReviewEvent;
import com.bank.service.ReviewEventService;
import com.bank.utils.mappers.impl.ReviewEventMapper;
import com.bank.validators.ReviewEventDTOValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews/events")
@RequiredArgsConstructor
public class ReviewEventContoller extends MainController{
    private final ReviewEventService reviewEventService;
    private final ReviewEventMapper reviewEventMapper;
    private final ReviewEventDTOValidator reviewEventDTOValidator;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(reviewEventMapper.toDTOs(reviewEventService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{review_id}")
    public ResponseEntity<Object> getById(@PathVariable("review_id") Long id){
        ReviewEvent reviewLandmark = reviewEventService.getById(id);
        return new ResponseEntity<>(reviewEventMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }

    @DeleteMapping("/{review_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("review_id") Long id){
        reviewEventService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createNewLandmarkReview(@RequestBody ReviewEventDTO reviewLandmarkDTO,
                                                          BindingResult bindingResult){
        reviewEventDTOValidator.validate(reviewLandmarkDTO, bindingResult);
        checkBindingResult(bindingResult);
        ReviewEvent reviewLandmark = reviewEventMapper.fromDTO(reviewLandmarkDTO);
        reviewLandmark = reviewEventService.save(reviewLandmark);
        System.out.println(reviewLandmark.getId());
        System.out.println(reviewLandmark.getTitle());
        return new ResponseEntity<>(reviewEventMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }

    @PatchMapping("/{review_id}")
    public ResponseEntity<Object> updateReview(@PathVariable("review_id") Long reviewId,
                                               @RequestBody ReviewEventDTO reviewLandmarkDTO,
                                               BindingResult bindingResult){
        reviewEventDTOValidator.validate(reviewLandmarkDTO, bindingResult);
        ReviewEvent reviewLandmark = reviewEventMapper.fromDTO(reviewLandmarkDTO);
        reviewLandmark = reviewEventService.update(reviewId, reviewLandmark);
        return new ResponseEntity<>(reviewEventMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }
}
