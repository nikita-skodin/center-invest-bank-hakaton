package com.bank.dto;

import com.bank.models.Event;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewEventDTO {
    private Long id;
    private String title;
    private String message;
    private int stars;
    private Long event_id;
}
