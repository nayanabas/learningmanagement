package com.lms.course.query.api.handlers;

import com.lms.course.query.api.dto.CourseLookupResponse;
import com.lms.course.query.api.queries.FindCourseByCourseNameQuery;
import com.lms.course.query.api.queries.FindCourseByTechnologyQuery;
import com.lms.course.query.api.queries.FindAllCourseQuery;

public interface CourseQueryHandler {
    CourseLookupResponse findCourseByTechnology(FindCourseByTechnologyQuery query);
    CourseLookupResponse findCourseByCourseName(FindCourseByCourseNameQuery query);
    CourseLookupResponse findAllCourse(FindAllCourseQuery query);

}
