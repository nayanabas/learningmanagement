package com.lms.course.core.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseRemovedEvent {
    private String id;
    private String name;

}
