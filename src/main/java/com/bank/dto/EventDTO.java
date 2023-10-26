package com.bank.dto;

import com.bank.models.Address;
import com.bank.models.Event;
import com.bank.models.ReviewEvent;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@ToString
@Schema(description = "Event DTO")
public class EventDTO {
    @Schema(name = "id", example = "1")
    private Long id;

    @Schema(name = "title", example = "This is the name of the event")
    @NotBlank(message = "title should not be null")
    private String title;

    @Schema(name = "description", example = "This is the description of the event")
    @NotBlank(message = "description should not be null")
    private String description;

    @JsonProperty("number")
    private String number;

    @Schema(name = "images", example = "This is the images of the event")
    @Builder.Default
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> images = new ArrayList<>();

    @Schema(name = "Date of event publish", example = "timestamp")//TODO
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant dateOfPublish = Instant.now();

    @Schema(name = "date_of_event", example = "timestamp")
    @JsonProperty("date_of_event")
    private Instant dateOfEvent;

    @Schema(name = "total_stars", example = "100")
    @JsonProperty("total_stars")
    private Double totalStars;

    @Schema(name = "review_counter", example = "20")
    @JsonProperty("review_counter")
    private Double reviewCounter;

    @Schema(name = "address")
    private String address;

    @Schema(name = "coordinates")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String coordinates;

    @Schema(name = "rating", example = "3.23")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Builder.Default
    private Double rating = 0.0;

    @Schema(name = "start_time", example = "12")
    @JsonProperty("start_time")
    private Instant startTime;

    @Schema(name = "end_time", example = "21")
    @JsonProperty("end_time")
    private Instant endTime;
}
