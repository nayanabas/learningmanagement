package com.lms.course.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.Min;

@Data
@Builder
public class RemoveCourseCommand {
    @TargetAggregateIdentifier
    private String id;


    private String name;
}
