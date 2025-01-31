package com.deveasy.email_service.core;

import com.deveasy.email_service.core.DTO.SendEmailDTO;

import java.io.IOException;

public interface SendEmailUseCase {
    void sendEmail(SendEmailDTO sendEmailDTO) throws IOException;
}
