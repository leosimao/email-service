package com.deveasy.email_service.core;

import java.io.IOException;

public interface SendEmailUseCase {
    void sendEmail(SendEmailDTO sendEmailDTO) throws IOException;
}
