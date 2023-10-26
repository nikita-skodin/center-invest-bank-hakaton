package com.bank.dto;

import com.bank.models.Rating;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User DTO")
public class UserDTO {

    @Schema(name = "User id", example = "1")
    private Long id;

    @Schema(name = "Username", example = "mkr")
    private String username;

    @Schema(name = "User email", example = "mrk@gmail.com")
    private String email;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String password;

    @Schema(name = "Password confirmation", example = "12345")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY,
            value = "password_confirmation")
    private String passwordConfirmation;

    @Schema(name = "User experience", example = "12345")
    private Integer points;

    @Schema(name = "User rank", example = "New member")
    private String rank;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY,
            value = "confirmation_code")
    @Schema(name = "4-digit code for email confirmation", example = "5328")
    private String confirmationCode;

}
