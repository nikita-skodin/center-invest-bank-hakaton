package com.bank.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "reviews_landmark")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewLandmark {
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
    @JoinColumn(name = "landmark_id", referencedColumnName = "id")
    private Landmark landmark;

    @Column(name = "likes")
    private Long likes;
}
