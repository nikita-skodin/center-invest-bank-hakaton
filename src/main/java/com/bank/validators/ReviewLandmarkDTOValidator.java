package com.bank.validators;

import com.bank.dto.ReviewLandmarkDTO;
import com.bank.service.LandmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ReviewLandmarkDTOValidator implements Validator {
    private final LandmarkService landmarkService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(ReviewLandmarkDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReviewLandmarkDTO reviewLandmarkDTO = (ReviewLandmarkDTO) target;
        landmarkService.getById(reviewLandmarkDTO.getLandmark_id());
    }
}
