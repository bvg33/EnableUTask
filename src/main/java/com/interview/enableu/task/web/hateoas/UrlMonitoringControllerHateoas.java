package com.interview.enableu.task.web.hateoas;

import com.interview.enableu.task.web.controller.UrlMonitoringController;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UrlMonitoringControllerHateoas implements Hateoas {
    @Override
    public void createHateoas(RepresentationModel model) {
        model.add(linkTo(methodOn(UrlMonitoringController.class).startMonitoring()).withSelfRel());
        model.add(linkTo(methodOn(UrlMonitoringController.class).stopMonitoring()).withSelfRel());
        model.add(linkTo(methodOn(UrlMonitoringController.class).getTheLatestMonitorResult()).withSelfRel());
    }
}
