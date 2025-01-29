package com.deveasy.email_service.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SendEmailDTO {
    private String destiny;
    private String destinyName;
    private String subject;
    private String body;
    private String from;
}

