package org.itstep.msk.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

//@RestController - когда мы сами хотим отдавать данные
@Controller //если используется шаблонизатор
public class MailController {

    @Autowired
    private JavaMailSender mailer;

    @Autowired
    private TemplateEngine engine;

    @GetMapping("/tm")
    public String templateMail() {
        Context context = new Context();
        context.setVariable("text", "Hello ITSTEP!!!");
        String body = engine.process("mail", context);

        MimeMessagePreparator preparator = message -> {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom("demo-honeywell@yandex.ru");
            helper.setTo("msk-itstep-org-java@yandex.ru");
            helper.setSubject("Thymeleaf");
            helper.setText(body, true);
        };

        mailer.send(preparator);

        return "index";
    }

/*
    @GetMapping("/")
    public String index() throws MessagingException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("demo-honeywell@yandex.ru");
        message.setTo("msk-itstep-org-java@yandex.ru");
        message.setSubject("Java Mail Sender Text");
        message.setText("Hello, ItStep!");

        mailer.send(message);


        MimeMessage fileMessage = mailer.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(fileMessage, true);
        helper.setFrom("demo-honeywell@yandex.ru");
        helper.setTo("msk-itstep-org-java@yandex.ru");
        helper.setSubject("Java Mail Sender Text");
        helper.setText("Attachment");

        FileSystemResource file = new FileSystemResource(
                new File("C:\\SSDMInfo.txt")
        );

        helper.addAttachment("SSDMInfo.txt", file);

        mailer.send(fileMessage);

        return "index"; //будет возращен index.html
    }
    */
}
