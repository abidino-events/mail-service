package dev.abidino.email;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mail")
record Controller(MailService mailService) {
    @PostMapping("/send")
    void sendMail(@RequestBody @Valid MailDto mailDto) {
        mailService.send(mailDto);
    }

    @GetMapping
    String test() {
        return "check";
    }
}
