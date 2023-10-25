package com.bank.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LandmarkDTO {
    private Long id;
    private String title;
    private String description;
    private AddressDTO address;
    private Double rating;
    private List<ReviewLandmarkDTO> reviews;
}
