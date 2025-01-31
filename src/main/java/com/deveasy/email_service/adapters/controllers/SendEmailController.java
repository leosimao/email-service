package com.deveasy.email_service.adapters.controllers;

import com.deveasy.email_service.core.DTO.SendEmailDTO;
import com.deveasy.email_service.core.SendEmailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/email")
public class SendEmailController {
    private final SendEmailUseCase sendEmailUseCase;

    @Autowired
    public SendEmailController(SendEmailUseCase sendEmailUseCase) {
        this.sendEmailUseCase = sendEmailUseCase;
    }

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody SendEmailDTO sendEmailDTO) throws IOException {
        sendEmailUseCase.sendEmail(sendEmailDTO);
    }
}
