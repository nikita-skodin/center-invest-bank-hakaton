package com.bank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Address dto")
public class AddressDTO {

    @Schema(name = "Address id", example = "1")
    private Long id;
    private String address;
    private String coordinates;
    //

    @Schema(name = "Country name", example = "Belarus")
    private String country;

    @Schema(name = "City name", example = "Minsk")
    private String city;

    @Schema(name = " name", example = "1")
    private String street;

}
