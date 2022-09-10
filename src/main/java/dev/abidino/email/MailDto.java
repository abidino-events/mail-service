package dev.abidino.email;

import javax.validation.constraints.NotNull;

record MailDto(@NotNull(message = "Recipient must be not null") String recipient,
               @NotNull(message = "MsgBody must be not null") String msgBody,
               @NotNull(message = "Subject must be not null") String subject) {
}