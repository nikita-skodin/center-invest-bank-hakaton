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
    
    @Schema(name = "Address id", example = "Агрогородок Лесной,Александрова улица, дом 7") // TODO: 026
    private String address;
    
    @Schema(name = "Address id", example = "54.013194, 27.68137") // TODO: 026
    private String coordinates;
    //
}
