package com.wendy.studentmanagementapp.controller;

import com.wendy.studentmanagementapp.model.Teacher;
import com.wendy.studentmanagementapp.model.Course;
import com.wendy.studentmanagementapp.service.TeacherService;
import com.wendy.studentmanagementapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    // Add new teacher
    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        // Find the course by name
        Course course = courseService.getCourseByName(teacher.getCourse().getName());

        if (course == null) {
            // If course not found, return null or handle error
            throw new RuntimeException("Course not found");
        }

        // Set the course for the teacher
        teacher.setCourse(course);

        // Save teacher with the correct course
        return teacherService.saveTeacher(teacher);
    }

    // Get all teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
}
