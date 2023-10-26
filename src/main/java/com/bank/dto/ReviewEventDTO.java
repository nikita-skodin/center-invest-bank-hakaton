package com.bank.dto;

import com.bank.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Review for event dto")
public class ReviewEventDTO {

    @Schema(name = "Event review id", example = "1")
    private Long id;

    @Schema(name = "Review title", example = "This is review")
    private String title;

    @Schema(name = "Review message", example = "This is description about review")
    private String message;

    @Schema(name = "Event id of review ", example = "1")
    private Long event_id;

    @Schema(name = "Count of stars, which user gives to this event", example = "1")
    private int stars;

    @Schema(name = "Count of likes fot this review", example = "100")
    private Long likes;
}
