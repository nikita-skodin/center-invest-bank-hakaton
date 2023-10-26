package com.bank.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenerationTime;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    @CollectionTable(name = "events_images")
    @ElementCollection
    @Builder.Default
    private List<String> images = new ArrayList<>();

    @Column(name = "date_of_publishment")
    @Builder.Default
    private Instant dateOfPublish = Instant.now();

    @Column(name = "date_of_event")
    private Instant dateOfEvent;

    @Column(name="address")
    private String address;

    @Column(name = "contact_number")
    private String number;

    @Column(name = "total_stars")
    private Double totalStars;

    @Column(name = "review_counter")
    private Double reviewCounter;

    @Column(name = "rating")
    @Builder.Default
    private Double rating = 0.0;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    public double getRating(){
        if (this.totalStars != null && this.reviewCounter != null) {
            rating = this.totalStars / this.reviewCounter;
        }
        return rating;
    }
}
