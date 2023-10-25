package com.bank.dto;

import com.bank.models.Landmark;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Review for landmark dto")
public class ReviewLandmarkDTO {
    @Schema(name = "Landmark review id", example = "1")
    private Long id;
    @Schema(name = "Review title", example = "This is review")
    private String title;
    @Schema(name = "Review message", example = "This is description about review")
    private String message;
    @Schema(name = "Landmark id of review ", example = "1")
    private Long landmark_id;
    @Schema(name = "Count of stars, which user gives to this landmark", example = "1")
    private int stars;
    @Schema(name = "Count of likes fot this review", example = "100")
    private Long likes;
}
