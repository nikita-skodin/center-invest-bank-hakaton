package com.bank.dto;

import com.bank.models.Address;
import com.bank.models.ReviewEvent;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {

    private Long id;

    private String title;

    private String description;

    @Builder.Default
    private List<String> images = new ArrayList<>();

    private Instant dateOfPublish;

    private Instant dateOfEvent;

    private Address address;

    private Integer totalStars;

    private Integer reviewCounter;

    private double rating;

    @Builder.Default
    private List<ReviewEvent> review = new ArrayList<>();
}
