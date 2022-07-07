package com.interview.enableu.task.web.hateoas;

import org.springframework.hateoas.RepresentationModel;

public interface Hateoas {
    void createHateoas(RepresentationModel representationModel);
}
