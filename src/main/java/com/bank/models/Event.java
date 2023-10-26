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
@ToString
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

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String number;

    @Column(name = "total_stars")
    private Integer totalStars;

    @Column(name = "review_counter")
    private Integer reviewCounter;

    @Column(name = "rating")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double rating;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;


}
