package com.bank.models;

import com.bank.utils.enums.RatingStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "users_rating")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RatingStatus status;

    @Column(name = "points")
    private Integer points;
}
