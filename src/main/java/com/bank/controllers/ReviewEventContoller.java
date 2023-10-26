package com.bank.controllers;

import com.bank.dto.ReviewEventDTO;
import com.bank.models.ReviewEvent;
import com.bank.service.RatingService;
import com.bank.service.ReviewEventService;
import com.bank.service.UserService;
import com.bank.utils.mappers.impl.ReviewEventMapper;
import com.bank.validators.ReviewEventDTOValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews/events")
@RequiredArgsConstructor
@Tag(name = "Event reviews controller", description = "Event reviews API")
public class ReviewEventContoller extends MainController{
    private final ReviewEventService reviewEventService;
    private final ReviewEventMapper reviewEventMapper;
    private final ReviewEventDTOValidator reviewEventDTOValidator;
    private final RatingService ratingService;

    @Operation(summary = "Get all event reviews")
    @GetMapping
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(reviewEventMapper.toDTOs(reviewEventService.getAll()), HttpStatus.OK);
    }

    @Operation(summary = "Get event review by id")
    @GetMapping("/{review_id}")
    public ResponseEntity<Object> getById(@PathVariable("review_id") Long id){
        ReviewEvent reviewEvent = reviewEventService.getById(id);
        return new ResponseEntity<>(reviewEventMapper.toDTO(reviewEvent), HttpStatus.OK);
    }

    @Operation(summary = "Delete review by id")
    @DeleteMapping("/{review_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("review_id") Long id){
        reviewEventService.deleteById(id);
    }

    @Operation(summary = "Create new event review")
    @PostMapping
    public ResponseEntity<Object> createNewEventReview(@RequestBody ReviewEventDTO reviewEventDTODTO,
                                                          BindingResult bindingResult){
        reviewEventDTOValidator.validate(reviewEventDTODTO, bindingResult);
        checkBindingResult(bindingResult);
        ReviewEvent reviewEvent = reviewEventMapper.fromDTO(reviewEventDTODTO);
        reviewEvent = reviewEventService.save(reviewEvent);
        ratingService.updateUserRating(50); //TODO
        return new ResponseEntity<>(reviewEventMapper.toDTO(reviewEvent), HttpStatus.OK);
    }


    @Operation(summary = "Update existing review")
    @PatchMapping("/{review_id}")
    public ResponseEntity<Object> updateReview(@PathVariable("review_id") Long reviewId,
                                               @RequestBody ReviewEventDTO reviewEventDTODTO,
                                               BindingResult bindingResult){
        reviewEventDTOValidator.validate(reviewEventDTODTO, bindingResult);
        ReviewEvent reviewEvent = reviewEventMapper.fromDTO(reviewEventDTODTO);
        reviewEvent = reviewEventService.update(reviewId, reviewEvent);
        return new ResponseEntity<>(reviewEventMapper.toDTO(reviewEvent), HttpStatus.OK);
    }

    @Operation(summary = "Put like for a review")
    @PatchMapping("/{review_id}/likes")
    public ResponseEntity<Object> putLikeForReview(@PathVariable("review_id") Long reviewId){
        ReviewEvent reviewEvent = reviewEventService.putLikeForReview(reviewId);
        ratingService.updateUserRating(1); //TODO
        return new ResponseEntity<>(reviewEventMapper.toDTO(reviewEvent), HttpStatus.OK);
    }
}
