package com.lms.course.cmd.api.aggregates;

import com.lms.course.cmd.api.commands.RegisterCourseCommand;
import com.lms.course.cmd.api.commands.RemoveCourseCommand;
import com.lms.course.core.events.CourseRegisterdEvent;
import com.lms.course.core.events.CourseRemovedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class CourseAggregate {
    @AggregateIdentifier
    private String id;
//    private String accountHolderId;
//    private double balance;

    @CommandHandler
    public CourseAggregate(RegisterCourseCommand command) {
        var event = CourseRegisterdEvent.builder()
                .id(command.getId())
                .courseName(command.getCourseName())
                .courseDescription(command.getCourseDescription())
                .technology(command.getTechnology())
                .duration(command.getDuration())
                .url(command.getUrl())
                .build();

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CourseRegisterdEvent event) {
        this.id = event.getId();
    }




    @CommandHandler
    public void handle(RemoveCourseCommand command) {
        var amount = command.getName();



        var event = CourseRemovedEvent.builder()
                .id(command.getId())
                .name(command.getName())
                .build();

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CourseRemovedEvent event) {
        this.id = event.getId();
    }


}
