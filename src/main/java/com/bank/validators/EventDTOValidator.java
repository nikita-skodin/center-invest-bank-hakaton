package com.bank.validators;

import com.bank.dto.EventDTO;
import com.bank.models.Event;
import com.bank.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EventDTOValidator implements Validator {

    private final EventService eventService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(EventDTOValidator.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EventDTO dto = (EventDTO) target;

        Optional<Event> eventByTitle = eventService.getEventByTitle(dto.getTitle());

        if (eventByTitle.isPresent() && !Objects.equals(eventByTitle.get().getId(), dto.getId())){
            errors.rejectValue("title", "400",
                    String.format("Event with name %s is already exist",
                            dto.getTitle()));
        }

        Instant startTime = dto.getStartTime();
        Instant endTime = dto.getEndTime();

        if (startTime.isAfter(endTime) || startTime.equals(endTime)){
            errors.rejectValue("startTime", "400",
                    "Time is incorrect");
        }
    }
}
