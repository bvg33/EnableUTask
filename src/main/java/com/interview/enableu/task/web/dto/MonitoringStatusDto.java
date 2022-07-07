package com.interview.enableu.task.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class MonitoringStatusDto extends RepresentationModel<MonitoringStatusDto> {
    private String message;
}
