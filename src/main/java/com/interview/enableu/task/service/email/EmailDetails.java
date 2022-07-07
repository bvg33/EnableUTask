package com.interview.enableu.task.service.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class EmailDetails {
    private String messageBody;
    private String subject;
}

