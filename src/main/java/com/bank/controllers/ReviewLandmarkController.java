package com.bank.controllers;

import com.bank.dto.ReviewLandmarkDTO;
import com.bank.models.ReviewLandmark;
import com.bank.service.RatingService;
import com.bank.service.ReviewLandmarkService;
import com.bank.utils.mappers.impl.ReviewLandmarkMapper;
import com.bank.validators.ReviewLandmarkDTOValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews/landmarks")
@RequiredArgsConstructor
@Tag(name = "Landmark reviews controller", description = "Landmark reviews API")
public class ReviewLandmarkController extends MainController {

    private final ReviewLandmarkService reviewLandmarkService;
    private final ReviewLandmarkMapper reviewLandmarkMapper;
    private final ReviewLandmarkDTOValidator reviewLandmarkDTOValidator;
    private final RatingService ratingService;

    @Operation(summary = "Get all landmark reviews")
    @GetMapping
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(reviewLandmarkMapper.toDTOs(reviewLandmarkService.getAll()), HttpStatus.OK);
    }

    @Operation(summary = "Get event review by id")
    @GetMapping("/{review_id}")
    public ResponseEntity<Object> getById(@PathVariable("review_id") Long id) {
        ReviewLandmark reviewLandmark = reviewLandmarkService.getById(id);
        return new ResponseEntity<>(reviewLandmarkMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }

    @Operation(summary = "Delete event review by id")
    @DeleteMapping("/{review_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("review_id") Long id) {
        reviewLandmarkService.deleteById(id);
    }

    @Operation(summary = "Create new event review")
    @PostMapping
    public ResponseEntity<Object> createNewLandmarkReview(
            @RequestBody @Valid ReviewLandmarkDTO reviewLandmarkDTO,
            BindingResult bindingResult) {
        reviewLandmarkDTOValidator.validate(reviewLandmarkDTO, bindingResult);
        checkBindingResult(bindingResult);
        ReviewLandmark reviewLandmark = reviewLandmarkMapper.fromDTO(reviewLandmarkDTO);
        reviewLandmark = reviewLandmarkService.save(reviewLandmark);
        ratingService.updateUserRating(50); //TODO
        return new ResponseEntity<>(reviewLandmarkMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }

    @Operation(summary = "Update existing event review")
    @PatchMapping("/{review_id}")
    public ResponseEntity<Object> updateReview(@PathVariable("review_id") Long reviewId,
                                               @RequestBody @Valid ReviewLandmarkDTO reviewLandmarkDTO,
                                               BindingResult bindingResult) {
        reviewLandmarkDTOValidator.validate(reviewLandmarkDTO, bindingResult);
        ReviewLandmark reviewLandmark = reviewLandmarkMapper.fromDTO(reviewLandmarkDTO);
        reviewLandmark = reviewLandmarkService.update(reviewId, reviewLandmark);
        return new ResponseEntity<>(reviewLandmarkMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }


    @Operation(summary = "Put like for a review")
    @PatchMapping("/{review_id}/likes")
    public ResponseEntity<Object> putLikeForReview(@PathVariable("review_id") Long reviewId) {
        ReviewLandmark reviewLandmark = reviewLandmarkService.putLikeForReview(reviewId);
        ratingService.updateUserRating(1); //TODO
        return new ResponseEntity<>(reviewLandmarkMapper.toDTO(reviewLandmark), HttpStatus.OK);
    }
}
