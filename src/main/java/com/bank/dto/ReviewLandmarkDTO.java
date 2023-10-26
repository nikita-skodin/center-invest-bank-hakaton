package com.bank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Review for landmark dto")
public class ReviewLandmarkDTO {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "title", example = "This is review")
    private String title;
    @Schema(name = "message", example = "This is description about review")
    private String message;
    @Schema(name = "landmark_id", example = "1")
    private Long landmark_id;
    @Schema(name = "stars", example = "1")
    private int stars;
    @Schema(name = "likes", example = "100")
    private Long likes;
}
