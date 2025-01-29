package com.deveasy.email_service.adapters.controllers;

import com.deveasy.email_service.application.SendEmailUseCaseImpl;
import com.deveasy.email_service.core.SendEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/email")
public class SendEmailController {

    private final SendEmailUseCaseImpl sendEmailUseCaseImpl;

    @Autowired
    public SendEmailController(SendEmailUseCaseImpl sendEmailUseCase) {
        this.sendEmailUseCaseImpl = sendEmailUseCase;
    }

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody SendEmailDTO sendEmailDTO) throws IOException {
        sendEmailUseCaseImpl.sendEmail(sendEmailDTO);
    }
}
