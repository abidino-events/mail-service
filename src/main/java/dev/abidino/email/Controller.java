package dev.abidino.email;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/mail")
record Controller(MailService mailService) {
    @PostMapping("/send")
    void sendMail(@RequestBody @Valid MailDto mailDto) {
        mailService.send(mailDto);

    }
    @GetMapping("/health")
    String test(HttpServletRequest httpServletRequest) {
        return "good";
    }
}
