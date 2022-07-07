package com.interview.enableu.task.service.helper;

import static com.interview.enableu.task.service.helper.PropertiesHelper.URL;

public class ConstantsHelper {
    public static final String AVAILABLE = "available";
    public static final String UNAVAILABLE = "unavailable";
    public static final String MESSAGE_SUBJECT = "URL monitoring updates";
    public static final String START_MONITORING_MESSAGE = URL + " is monitoring now. We will send updates to your email.";
    public static final String STOP_MONITORING_MESSAGE =  URL + " is not monitoring now.";
    public static final String URL_STATUS_NOT_FIND_EXCEPTION_MESSAGE = "Url has not been checked yet, please try again later.";
    public static final String START_ENDPOINT_LOG_MESSAGE = "/start endpoint was called";
    public static final String STOP_ENDPOINT_LOG_MESSAGE = "/stop endpoint was called";
    public static final String RESULT_ENDPOINT_LOG_MESSAGE = "/result endpoint was called";
    public static final String SEND_EMAIL_LOG_MESSAGE = "Email with monitoring result was sent";
    public static final String MESSAGE = "message";
    public static final String EMAIL_TEMPLATE = "email.ftlh";
}
