package com.interview.enableu.task.service.schedule;

import com.interview.enableu.task.service.email.EmailDetails;
import com.interview.enableu.task.service.email.EmailService;
import com.interview.enableu.task.service.url.UrlUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledFuture;

import static com.interview.enableu.task.service.helper.ConstantsHelper.*;
import static com.interview.enableu.task.service.helper.PropertiesHelper.CRON;

@Component
@EnableScheduling
public class EmailSubscriptionManager implements Runnable {
    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UrlUtilService urlUtilService;

    private ScheduledFuture<?> future;

    @Override
    public void run() {
        urlUtilService.checkUrlConnection();
        String urlStatusText = urlUtilService.createUrlStatusMessageText();
        emailService.sendSimpleMail(new EmailDetails(urlStatusText, MESSAGE_SUBJECT));
    }

    public void subscribeToNewsletter() {
        future = scheduler.schedule(this, new CronTrigger(CRON));
    }

    public void cancelNewsLetterSubscription() {
        if (future != null) {
            future.cancel(true);
        }
    }
}
