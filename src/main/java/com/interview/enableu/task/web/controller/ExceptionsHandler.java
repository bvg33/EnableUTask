package com.interview.enableu.task.web.controller;

import com.interview.enableu.task.exception.UrlStatusNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler {
    @ExceptionHandler(UrlStatusNotFoundException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), INTERNAL_SERVER_ERROR);
    }
}
