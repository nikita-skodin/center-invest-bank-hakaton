package com.bank.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "review_landmark")
@Builder
public class ReviewForLandmark{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "stars")
    private int stars;

    @ManyToOne
    @Column(name = "event")
    private Landmark landmark;
}
