package com.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Landmark DTO")
public class LandmarkDTO {

    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "title", example = "This is the name of the landmark")
    @NotBlank(message = "title should not be null")
    private String title;
    @Schema(name = "description", example = "This is the description of the landmark")
    @NotBlank(message = "description should not be null")
    private String description;

    @Schema(name = "images")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> images = new ArrayList<>();

    @Schema(name = "address")
    @NotBlank(message = "address should not be null")
    private String address;

    @Schema(name = "coordinates")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String coordinates;

    @Schema(name = "rating", example = "3.23")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Builder.Default
    private Double rating = 0.0;

    @Schema(name = "reviews", example = "This is the name of the landmark")
    private List<ReviewLandmarkDTO> reviews;

    @Schema(name = "contact_number", example = "+375447517324")
    @JsonProperty("contact_number")
    private String contactNumber;

    @Schema(name = "working_hours", example = "12-21")
    @JsonProperty("working_hours")
    private String workingHours;

}
