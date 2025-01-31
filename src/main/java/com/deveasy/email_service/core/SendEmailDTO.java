package com.deveasy.email_service.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SendEmailDTO {
    @JsonProperty("to")
    private String destiny;

    @JsonProperty("toname")
    private String destinyName;

    private String subject;

    @JsonProperty("text")
    private String body;

    private String from;
}

