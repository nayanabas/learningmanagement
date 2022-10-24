package com.lms.course.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class RegisterCourseCommand {
    @TargetAggregateIdentifier
    private String id;

    @NotNull(message = "no course name was supplied.")
    @Max(value = 20, message = "Course name should be less than 20 character")
    private String courseName;

    @NotNull(message = "no technology was supplied.")
    private String technology ;

    @NotNull(message = "no course Description was supplied.")
    @Max(value = 100, message = "Course description should be less than 100 character")
    private String  courseDescription;

    @NotNull(message = "no url was supplied.")
    private String  url;

    @NotNull(message = "no duration was supplied.")
    private int duration;


}
