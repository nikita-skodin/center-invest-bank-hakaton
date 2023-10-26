package com.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Review for event dto")
public class ReviewEventDTO {

    @Schema(name = "id", example = "1")
    private Long id;

    @Schema(name = "title", example = "This is review")
    @NotBlank(message = "title should not be blank")
    private String title;

    @Schema(name = "message", example = "This is description about review")
    @NotBlank(message = "message should not be blank")
    private String message;

    @Schema(name = "event_id", example = "1")
    @JsonProperty("event_id")
    private Long eventId;

    @Schema(name = "stars", example = "1")
    private int stars;

    @Schema(name = "likes", example = "100")
    private Long likes;
}
