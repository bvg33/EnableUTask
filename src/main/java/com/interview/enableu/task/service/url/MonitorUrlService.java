package com.interview.enableu.task.service.url;

import com.interview.enableu.task.service.schedule.EmailSubscriptionManager;
import com.interview.enableu.task.web.dto.MonitoringStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.interview.enableu.task.service.helper.ConstantsHelper.START_MONITORING_MESSAGE;
import static com.interview.enableu.task.service.helper.ConstantsHelper.STOP_MONITORING_MESSAGE;

@Service
public class MonitorUrlService {
    @Autowired
    private EmailSubscriptionManager emailManager;

    @Autowired
    private UrlUtilService urlUtilService;

    public MonitoringStatusDto startMonitorUrl() {
        emailManager.subscribeToNewsletter();
        return new MonitoringStatusDto(START_MONITORING_MESSAGE);
    }

    public MonitoringStatusDto stopMonitorUrl() {
        emailManager.cancelNewsLetterSubscription();
        return new MonitoringStatusDto(STOP_MONITORING_MESSAGE);
    }

    public MonitoringStatusDto getLatestResult() {
        String urlStatus = urlUtilService.createUrlStatusMessageText();
        return new MonitoringStatusDto(urlStatus);
    }
}
