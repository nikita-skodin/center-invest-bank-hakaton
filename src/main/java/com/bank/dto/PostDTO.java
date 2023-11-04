package com.bank.dto;

import com.bank.utils.enums.PostType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {

    private Long id;
    private String title;
    private String description;
    private LocationDTO location;
    private String type;
    private Double rating;
    @JsonProperty(value = "date_of_publish")
    private Instant dateOfPublish;
    @JsonProperty(value = "date_of_begin")
    private Instant dateOfBegin;
    @JsonProperty(value = "date_of_end")
    private Instant dateOfEnd;
}
