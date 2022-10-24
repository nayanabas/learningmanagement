package com.lms.course.query.api.repositories;

import com.lms.course.core.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, String> {
    Optional<Course> findByCourseName(String courseName);

    List<Course> findByTechnology(String technology);

    boolean deleteByName(String courseName);

}
