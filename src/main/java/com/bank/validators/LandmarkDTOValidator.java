package com.bank.validators;

import com.bank.dto.LandmarkDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LandmarkDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(LandmarkDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
