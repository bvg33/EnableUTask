package com.interview.enableu.task.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesHelper {
    public static String URL;
    public static String CRON;
    public static String RECIPIENT_MAIL;

    public static String SENDER_MAIL;

    @Autowired
    public PropertiesHelper(@Value("${monitoring.url}") String url,
                            @Value("${cron}") String cron,
                            @Value("${recipient.mail}") String recipientMail,
                            @Value("${spring.mail.username}") String senderMail) {
        PropertiesHelper.URL = url;
        PropertiesHelper.CRON = cron;
        PropertiesHelper.RECIPIENT_MAIL = recipientMail;
        PropertiesHelper.SENDER_MAIL = senderMail;
    }

}
