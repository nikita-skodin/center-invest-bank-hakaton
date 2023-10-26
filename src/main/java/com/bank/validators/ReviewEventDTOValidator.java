package com.bank.validators;

import com.bank.dto.ReviewEventDTO;
import com.bank.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ReviewEventDTOValidator implements Validator {
    private final EventService eventService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(ReviewEventDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReviewEventDTO reviewEventDTO = (ReviewEventDTO) target;
//        eventService.getById(reviewEventDTO.getEvent_id());
    }
}
