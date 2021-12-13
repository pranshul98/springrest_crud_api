package com.app.springrest.controller;

import com.app.springrest.entities.Courses;
import com.app.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to Home Page";
    }


    //get the courses
    @GetMapping("/courses")
    public List<Courses> getCoursesList() {
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Courses getCourses(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Courses addCourses(@RequestBody Courses courses) {

        return this.courseService.addCourse(courses);
    }

    @PutMapping("/courses/{courseId}")
    public Courses updateCourses(@RequestBody Courses newCourse,@PathVariable("courseId") String courseId) {
        return this.courseService.updateCourse(newCourse,Integer.parseInt(courseId));
    }

    @DeleteMapping("/courses/{coureseId}")
    public ResponseEntity<HttpStatus> deleteCourses(@PathVariable("coureseId") String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
