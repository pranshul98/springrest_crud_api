package com.app.springrest.services;

import com.app.springrest.entities.Courses;

import java.util.List;

public interface CourseService {
    public List<Courses> getCourses();
    public Courses getCourse(long courseId);
    public Courses addCourse(Courses courses);
    public Courses updateCourse(Courses newCourse,int courseId);
    public void deleteCourse(long courseId);
}
