package com.bank.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "landmark")
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




}