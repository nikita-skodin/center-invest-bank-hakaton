package com.bank.controllers;

import com.bank.dto.ReviewLandmarkDTO;
import com.bank.models.ReviewLandmark;
import com.bank.service.ReviewLandmarkService;
import com.bank.utils.mappers.impl.ReviewLandmarkMapper;
import com.bank.validators.ReviewLandmarkDTOValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews/landmarks")
@RequiredArgsConstructor
public class ReviewLandmarkController extends MainController {

    private final ReviewLandmarkService reviewLandmarkService;
    private final ReviewLandmarkMapper reviewLandmarkMapper;
    private final ReviewLandmarkDTOValidator reviewLandmarkDTOValidator;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(reviewLandmarkMapper.toDTOs(reviewLandmarkService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{review_id}")
    public ResponseEntity<Object> getById(@PathVariable("review_id") Long id){
        ReviewLandmark reviewLandmark = reviewLandmarkService.getById(id);
        return new ResponseEntity<>(reviewLandmarkMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }

    @DeleteMapping("/{review_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("review_id") Long id){
        reviewLandmarkService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createNewLandmarkReview(@RequestBody ReviewLandmarkDTO reviewLandmarkDTO,
                                                          BindingResult bindingResult){
        reviewLandmarkDTOValidator.validate(reviewLandmarkDTO, bindingResult);
        checkBindingResult(bindingResult);
        ReviewLandmark reviewLandmark = reviewLandmarkMapper.fromDTO(reviewLandmarkDTO);
        reviewLandmark = reviewLandmarkService.save(reviewLandmark);
        System.out.println(reviewLandmark.getId());
        System.out.println(reviewLandmark.getTitle());
        return new ResponseEntity<>(reviewLandmarkMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }

    @PatchMapping("/{review_id}")
    public ResponseEntity<Object> updateReview(@PathVariable("review_id") Long reviewId,
                                               @RequestBody ReviewLandmarkDTO reviewLandmarkDTO,
                                               BindingResult bindingResult){
        reviewLandmarkDTOValidator.validate(reviewLandmarkDTO, bindingResult);
        ReviewLandmark reviewLandmark = reviewLandmarkMapper.fromDTO(reviewLandmarkDTO);
        reviewLandmark = reviewLandmarkService.update(reviewId, reviewLandmark);
        return new ResponseEntity<>(reviewLandmarkMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }
}
