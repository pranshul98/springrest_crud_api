package com.app.springrest.services;

import com.app.springrest.entities.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    List<Courses> list;
    private Courses updatedCourse;

    public CourseServiceImpl() {

        list = new ArrayList<>();
        list.add(new Courses(1443, "Java Core", "this is on java core"));
        list.add(new Courses(1434, "Spring Boot", "this is on Spring Boot"));
    }

    @Override
    public List<Courses> getCourses() {
        return list;
    }

    @Override
    public Courses getCourse(long courseId) {
        Courses c = null;
        for (Courses course:list) {
            if (course.getId() == courseId) {
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Courses addCourse(Courses courses) {
        list.add(courses);
        return courses;
    }

    @Override
    public Courses updateCourse(Courses newCourse, int courseId){
        list = list.stream().map(c ->{
            if (c.getId()==courseId){
                c.setTitle(newCourse.getTitle());
                c.setDescription(newCourse.getDescription());
            }
            return c;
        }).collect(Collectors.toList());

        return newCourse;
    }

    @Override
    public void deleteCourse(long parseLong) {
        list = this.list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
    }

}
