package com.bank.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @JoinColumn(name="address_id")
    @OneToOne
    private Address address;

    @Column(name = "total_stars")
    private double totalStars;

    @Column(name = "review_counter")
    private int reviewCounter;

    @Column(name = "rating")
    private double rating;

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


}
