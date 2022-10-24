package com.lms.course.query.api.dto;

import com.lms.course.core.dto.BaseResponse;
import com.lms.course.core.models.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseLookupResponse extends BaseResponse {
    private List<Course> courses;

    public CourseLookupResponse(String message) {
        super(message);
    }

    public CourseLookupResponse(String message, List<Course> course) {
        super(message);
        this.courses = course;
    }

    public CourseLookupResponse(String message, Course course) {
        super(message);
        this.courses = new ArrayList<>();
        this.courses.add(course);
    }

//    public void setAccounts(List<BankAccount> accounts) {
//        this.accounts = accounts;
//    }
//
//    public List<BankAccount> getAccounts() {
//        return this.accounts;
//    }
}
