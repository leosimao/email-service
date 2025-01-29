package com.deveasy.email_service.application;

import com.deveasy.email_service.adapters.SendEmailAdapter;
import com.deveasy.email_service.core.SendEmailDTO;
import com.deveasy.email_service.core.SendEmailUseCase;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendEmailUseCaseImpl implements SendEmailUseCase {

    private final SendEmailAdapter sendEmailAdapter;

    public SendEmailUseCaseImpl(SendEmailAdapter sendEmailAdapter){
        this.sendEmailAdapter = sendEmailAdapter;
    }
    @Override
    public void sendEmail(SendEmailDTO sendEmailDTO) throws IOException {
        this.sendEmailAdapter.sendEmail(sendEmailDTO);
    }
}
