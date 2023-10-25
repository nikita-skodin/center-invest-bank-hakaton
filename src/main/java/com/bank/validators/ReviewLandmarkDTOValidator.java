package com.bank.validators;

import com.bank.dto.ReviewLandmarkDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReviewLandmarkDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(ReviewLandmarkDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
