package com.bank.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LandmarkDTO {
    private Long id;
    private String title;
    private String description;
    private AddressDTO address;
    private Double rating;
    private int reviewCounter;
    private String contactNumber;
    private String workingHours;
}
