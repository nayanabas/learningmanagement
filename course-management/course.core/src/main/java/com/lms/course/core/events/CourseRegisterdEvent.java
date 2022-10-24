package com.lms.course.core.events;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CourseRegisterdEvent {
    private String id;
    private String courseName;
    private String courseDescription;
    private String technology;
    private String url;
    private int duration;
}
