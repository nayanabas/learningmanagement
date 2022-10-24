package com.lms.course.query.api.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindCourseByTechnologyQuery {
    private String technology;
}
