package com.bank.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "landmarks")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Landmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="address")
    private String address;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "total_stars")
    private double totalStars;

    @Column(name = "review_counter")
    private int reviewCounter;

    @Column(name = "rating")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double rating;

    @OneToMany(mappedBy = "landmark")
    @Builder.Default
    private List<ReviewLandmark> reviews = new ArrayList<>();

    @NotNull
    @Column(name="contact_number")
    // TODO
    private String contactNumber;

    @NotNull
    @Column(name="working_hours")
    private String workingHours;

    @Column(name = "image")
    @CollectionTable(name = "landmarks_images")
    @ElementCollection
    @Builder.Default
    private List<String> images = new ArrayList<>();

}
