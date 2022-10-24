package com.lms.course.query.api.handlers;

import com.lms.course.core.models.Course;
import com.lms.course.query.api.repositories.CourseRepository;
import com.lms.course.core.events.CourseRegisterdEvent;
import com.lms.course.core.events.CourseRemovedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("bankaccount-group")
public class CourseEventHandlerImpl implements CourseEventHandler {
    private final CourseRepository courseRepo;

    @Autowired
    public CourseEventHandlerImpl(CourseRepository courseRepository) {
        this.courseRepo = courseRepository;
    }

    @EventHandler
    @Override
    public void on(CourseRegisterdEvent event) {
        var course = Course.builder()
                .id(event.getId())
                .courseDescription(event.getCourseDescription())
                .courseName(event.getCourseName())
                .technology(event.getTechnology())
                .url(event.getUrl())
                .build();

        courseRepo.save(course);
    }



    @EventHandler
    @Override
    public void on(CourseRemovedEvent event) {
        var flag = courseRepo.deleteByName(event.getName());
        System.out.println("deleted"+flag);

    }


}
