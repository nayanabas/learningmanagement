package com.lms.course.query.api.handlers;

import com.lms.course.core.events.CourseRegisterdEvent;
import com.lms.course.core.events.CourseRemovedEvent;

public interface CourseEventHandler {
    void on(CourseRegisterdEvent event);

    void on(CourseRemovedEvent event);

}
