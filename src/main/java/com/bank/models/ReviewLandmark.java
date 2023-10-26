package com.bank.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

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
    @Builder.Default
    private Long likes = 0L;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

//    @Column(name = "creation_time")
//    private Instant creationTime;
}
