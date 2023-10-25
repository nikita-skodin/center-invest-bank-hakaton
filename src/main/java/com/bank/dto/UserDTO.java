package com.bank.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    @JsonView()
    private String passwordConfiramtion;
}
