package com.interview.enableu.task.web.controller;

import com.interview.enableu.task.service.url.MonitorUrlService;
import com.interview.enableu.task.web.dto.MonitoringStatusDto;
import com.interview.enableu.task.web.hateoas.Hateoas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.interview.enableu.task.service.helper.ConstantsHelper.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/monitoring")
@Slf4j
@Tag(name = "Url monitoring controller", description = "Allows you to track the availability of the url")
public class UrlMonitoringController {

    @Autowired
    private Hateoas hateoas;

    @Autowired
    private MonitorUrlService service;

    @GetMapping("/start")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200", description = "Allows you to start monitor url and get emails with it status",
            content = {@Content(
                    mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MonitoringStatusDto.class)))
            })
    })
    public ResponseEntity startMonitoring() {
        log.info(START_ENDPOINT_LOG_MESSAGE);
        MonitoringStatusDto dto = service.startMonitorUrl();
        hateoas.createHateoas(dto);
        return ResponseEntity.status(OK).body(dto);
    }

    @GetMapping("/stop")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200", description = "Allows you to stop monitor url",
            content = {@Content(
                    mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MonitoringStatusDto.class)))
            })
    })
    public ResponseEntity stopMonitoring() {
        log.info(STOP_ENDPOINT_LOG_MESSAGE);
        MonitoringStatusDto dto = service.stopMonitorUrl();
        hateoas.createHateoas(dto);
        return ResponseEntity.status(OK).body(dto);
    }

    @GetMapping("/result")
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200", description = "Allows you to get the last url status",
            content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = MonitoringStatusDto.class)))
            })
    })
    public ResponseEntity getTheLatestMonitorResult() {
        log.info(RESULT_ENDPOINT_LOG_MESSAGE);
        MonitoringStatusDto dto = service.getLatestResult();
        hateoas.createHateoas(dto);
        return ResponseEntity.status(OK).body(dto);
    }
}
