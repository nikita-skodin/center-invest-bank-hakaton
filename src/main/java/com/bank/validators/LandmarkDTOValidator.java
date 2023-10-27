package com.bank.validators;

import com.bank.dto.LandmarkDTO;
import com.bank.models.Landmark;
import com.bank.service.LandmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LandmarkDTOValidator implements Validator {

    private final LandmarkService landmarkService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(LandmarkDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LandmarkDTO dto = (LandmarkDTO) target;

        Optional<Landmark> landmarkByTitle = Optional.ofNullable(landmarkService.getByTitle(dto.getTitle()));

        if (landmarkByTitle.isPresent() && !Objects.equals(landmarkByTitle.get().getId(), dto.getId())){
            errors.rejectValue("title", "400",
                    String.format("Landmark with name %s is already exist",
                            dto.getTitle()));
        }
    }
}
