package com.deveasy.email_service.adapters;

import com.deveasy.email_service.core.DTO.SendEmailDTO;

import java.io.IOException;

public interface SendEmailAdapter {
    void sendEmail(SendEmailDTO sendEmailDTO) throws IOException;
}
