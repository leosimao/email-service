package com.deveasy.email_service.infrastructure;

import com.deveasy.email_service.adapters.SendEmailAdapter;
import com.deveasy.email_service.core.DTO.SendEmailDTO;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendGridSendEmailAdapter implements SendEmailAdapter {

    private final String apiKeySendGrid;

    public SendGridSendEmailAdapter(@Value("${api.key.sendgrid}") String apiKeySendGrid) {
        this.apiKeySendGrid = apiKeySendGrid;
    }

    @Override
    public void sendEmail(SendEmailDTO sendEmailDTO) throws IOException {
        SendGrid sendGrid = new SendGrid(apiKeySendGrid);
        Email fromEmail = buildEmail(sendEmailDTO.getFrom());
        Email toEmail = buildEmail(sendEmailDTO.getDestiny());
        Content contentEmail = new Content();
        contentEmail.setType("text/plain");
        contentEmail.setValue(sendEmailDTO.getBody());
        String subjectEmail = sendEmailDTO.getSubject();
        Personalization emailPersonalization = new Personalization();
        emailPersonalization.addTo(toEmail);

        Mail mailComplete = buildMail(fromEmail, subjectEmail, emailPersonalization, contentEmail);
        sendRequestEmail(mailComplete, sendGrid);
    }

    private Mail buildMail(Email fromEmail,
                           String subjectEmail,
                           Personalization emailPersonalization,
                           Content contentEmail
    ) {
        Mail buildMail = new Mail();
        buildMail.setFrom(fromEmail);
        buildMail.setSubject(subjectEmail);
        buildMail.addPersonalization(emailPersonalization);
        buildMail.addContent(contentEmail);
        return buildMail;
    }

    private Email buildEmail(String email) {
        Email buildEmail = new Email();
        buildEmail.setEmail(email);
        return buildEmail;
    }

    private void sendRequestEmail(Mail mailComplete, SendGrid sendGrid) throws IOException {
        Request requestSendEmail = new Request();
        requestSendEmail.setMethod(Method.POST);
        requestSendEmail.setEndpoint("mail/send");
        requestSendEmail.setBody(mailComplete.build());
        sendGrid.api(requestSendEmail);
    }
}
