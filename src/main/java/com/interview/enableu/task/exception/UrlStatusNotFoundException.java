package com.interview.enableu.task.exception;

public class UrlStatusNotFoundException extends RuntimeException {
    public UrlStatusNotFoundException() {
    }

    public UrlStatusNotFoundException(String message) {
        super(message);
    }

    public UrlStatusNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UrlStatusNotFoundException(Throwable cause) {
        super(cause);
    }
}
