package com.bank.models;

import com.bank.utils.enums.RatingStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "users_rating")
public class Rating {
    @Id
    @OneToOne(mappedBy = "rating")
    private User user;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RatingStatus status;

    @Column(name = "points")
    private Integer points;
}
