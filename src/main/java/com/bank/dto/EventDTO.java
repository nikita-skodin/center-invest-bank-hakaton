package com.bank.dto;

import com.bank.models.Address;
import com.bank.models.Event;
import com.bank.models.ReviewEvent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Event DTO")
public class EventDTO {
    @Schema(name = "Event id", example = "1")
    private Long id;

    @Schema(name = "Event title", example = "This is the name of the event")
    @NotBlank(message = "title should not be null")
    private String title;

    @Schema(name = "Event description", example = "This is the description of the event")
    @NotBlank(message = "description should not be null")
    private String description;

    @Schema(name = "Event images", example = "This is the images of the event")
    @Builder.Default
    private List<String> images = new ArrayList<>();

    @Schema(name = "Date of event publish", example = "")//TODO
    private Instant dateOfPublish;

    @Schema(name = "Date of event", example = "")//TODO
    private Instant dateOfEvent;

    @Schema(name = "Landmark address")
    private Address address;

    @Schema(name = "Event rating", example = "3.23")
    private Double rating;

    @Schema(name = "Event reviews", example = "This is the name of the landmark")
    @Builder.Default
    private List<ReviewEvent> review = new ArrayList<>();
}
