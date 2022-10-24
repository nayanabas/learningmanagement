package com.lms.course.query.api.handlers;

import com.lms.course.core.models.Course;
import com.lms.course.query.api.queries.FindCourseByTechnologyQuery;
import com.lms.course.query.api.queries.FindAllCourseQuery;
import com.lms.course.query.api.repositories.CourseRepository;
import com.lms.course.query.api.dto.CourseLookupResponse;
import com.lms.course.query.api.dto.EqualityType;
import com.lms.course.query.api.queries.FindCourseByCourseNameQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseQueryHandlerImpl implements CourseQueryHandler {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseQueryHandlerImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @QueryHandler
    @Override
    public CourseLookupResponse findCourseByTechnology(FindCourseByTechnologyQuery query) {
        var courseIterator = courseRepository.findByTechnology(query.getTechnology());

        if (!courseIterator.iterator().hasNext())
            return new CourseLookupResponse("No Bank Accounts were Found!");

        var courses = new ArrayList<Course>();
        courseIterator.forEach(i -> courses.add(i));
        var count = courses.size();

        return new CourseLookupResponse("Successfully Returned " + count + " Bank Account(s)!", courses);
    }

    @QueryHandler
    @Override
    public CourseLookupResponse findCourseByCourseName(FindCourseByCourseNameQuery query) {
        var course = courseRepository.findByCourseName(query.getCourseName());
        var response = course.isPresent()
                ? new CourseLookupResponse("Course Successfully Returned!", course.get())
                : new CourseLookupResponse("No Course Found for Holder ID - " + query.getCourseName());

        return response;
    }

    @QueryHandler
    @Override
    public CourseLookupResponse findAllCourse(FindAllCourseQuery query) {
        var courseIterator = courseRepository.findAll();

        if (!courseIterator.iterator().hasNext())
            return new CourseLookupResponse("No Bank Accounts were Found!");

        var courses = new ArrayList<Course>();
        courseIterator.forEach(i -> courses.add(i));
        var count = courses.size();

        return new CourseLookupResponse("Successfully Returned " + count + " Bank Account(s)!", courses);
    }


}
