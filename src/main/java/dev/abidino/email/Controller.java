package dev.abidino.email;

import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mail")
record Controller(MailService mailService) {
    @PostMapping("/send")
    void sendMail(@RequestBody @Valid MailDto mailDto) {
        mailService.send(mailDto);

    }
    @GetMapping("/health")
    OAuth2AccessToken test(OAuth2AccessToken oAuth2AccessToken) {
        return oAuth2AccessToken;
    }
}
