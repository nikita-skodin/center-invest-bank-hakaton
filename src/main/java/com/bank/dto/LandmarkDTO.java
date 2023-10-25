package com.bank.dto;

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
}
