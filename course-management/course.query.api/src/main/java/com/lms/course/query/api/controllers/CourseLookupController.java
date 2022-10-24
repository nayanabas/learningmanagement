package com.lms.course.query.api.controllers;
import com.lms.course.query.api.dto.CourseLookupResponse;
import com.lms.course.query.api.dto.EqualityType;
import com.lms.course.query.api.queries.FindCourseByCourseNameQuery;
import com.lms.course.query.api.queries.FindCourseByTechnologyQuery;
import com.lms.course.query.api.queries.FindAllCourseQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/CourseLookup")
public class CourseLookupController {
    private final QueryGateway queryGateway;

    @Autowired
    public CourseLookupController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(path = "/")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public ResponseEntity<CourseLookupResponse> getAllCourse() {
        try {
            var query = new FindAllCourseQuery();
            var response = queryGateway.query(query, ResponseTypes.instanceOf(CourseLookupResponse.class)).join();

            if (response == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete get all courses request";
            System.out.println(e.toString());

            return new ResponseEntity<>(new CourseLookupResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/byId/{technology}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public ResponseEntity<CourseLookupResponse> getCourseBycourseName(@PathVariable(value = "technology") String technology) {
        try {
            var query = new FindCourseByTechnologyQuery(technology);
            var response = queryGateway.query(query, ResponseTypes.instanceOf(CourseLookupResponse.class)).join();

            if (response == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete get course by technology request";
            System.out.println(e.toString());

            return new ResponseEntity<>(new CourseLookupResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/byHolderId/{coursename}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public ResponseEntity<CourseLookupResponse> getCourseByCourseName(@PathVariable(value = "coursename") String courseame) {
        try {
            var query = new FindCourseByCourseNameQuery(courseame);
            var response = queryGateway.query(query, ResponseTypes.instanceOf(CourseLookupResponse.class)).join();

            if (response == null ) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete get account by holder ID request";
            System.out.println(e.toString());

            return new ResponseEntity<>(new CourseLookupResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
