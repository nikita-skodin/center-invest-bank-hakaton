package com.bank.dto;

import com.bank.models.Landmark;
import jakarta.persistence.*;

public class ReviewLandmarkDTO {
    private Long id;
    private String title;
    private String message;
    private int stars;
    private int likes;
}
