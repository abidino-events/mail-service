package dev.abidino.email;

import dev.abidino.email.exception.BadRequestException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
record MailService(JavaMailSender javaMailSender) {
    public void send(MailDto mailDto) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            String sender = SpringContext.getProperty("spring.mail.username");
            mailMessage.setFrom(sender);
            mailMessage.setTo(mailDto.recipient());
            mailMessage.setText(mailDto.msgBody());
            mailMessage.setSubject(mailDto.subject());
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            throw new BadRequestException("Error while Sending Mail : " + e.getMessage());
        }
    }
}
