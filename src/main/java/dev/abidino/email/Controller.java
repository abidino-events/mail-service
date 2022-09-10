package dev.abidino.email;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/mail")
record Controller(MailService mailService) {
    @PostMapping("send")
    void sendMail(@RequestBody @Valid MailDto mailDto) {
        mailService.send(mailDto);
    }
}
