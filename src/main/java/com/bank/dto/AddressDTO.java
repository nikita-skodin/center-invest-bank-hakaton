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
    
    @Schema(name = "Address id", example = "1") // TODO: 026  
    private String address;
    
    @Schema(name = "Address id", example = "1") // TODO: 026  
    private String coordinates;
    //
}
