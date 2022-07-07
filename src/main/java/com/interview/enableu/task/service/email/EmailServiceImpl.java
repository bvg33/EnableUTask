package com.interview.enableu.task.service.email;

import com.interview.enableu.task.exception.EmailSendingException;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static com.interview.enableu.task.service.helper.ConstantsHelper.*;
import static com.interview.enableu.task.service.helper.PropertiesHelper.RECIPIENT_MAIL;
import static com.interview.enableu.task.service.helper.PropertiesHelper.SENDER_MAIL;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration fmConfiguration;

    @Override
    public void sendSimpleMail(EmailDetails details) {
        try {
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeHelper = new MimeMessageHelper(mailMessage, true);
            setMailMessageInfo(mimeHelper, details);
            javaMailSender.send(mailMessage);

        } catch (MessagingException | IOException | TemplateException e) {
            log.error(e.getMessage());
            throw new EmailSendingException(e.getMessage());
        }
        log.info(SEND_EMAIL_LOG_MESSAGE);
    }

    private void setMailMessageInfo(MimeMessageHelper mimeHelper, EmailDetails details) throws MessagingException, IOException, TemplateException {
        mimeHelper.setFrom(SENDER_MAIL);
        mimeHelper.setTo(RECIPIENT_MAIL);
        String emailContent = getEmailContent(details.getMessageBody());
        mimeHelper.setText(emailContent, true);
        mimeHelper.setSubject(details.getSubject());
    }

    private String getEmailContent(String message) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put(MESSAGE, message);
        fmConfiguration.getTemplate(EMAIL_TEMPLATE).process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
