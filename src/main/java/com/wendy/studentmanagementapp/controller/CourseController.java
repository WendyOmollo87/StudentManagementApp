package com.wendy.studentmanagementapp.controller;

import com.wendy.studentmanagementapp.model.Course;
import com.wendy.studentmanagementapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Add a new course
    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    // Get all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getCourses();
    }

    // Get a course by ID
    @GetMapping("/{courseId}")
    public Optional<Course> getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    // Get a course by name
    @GetMapping("/name/{courseName}")
    public Course getCourseByName(@PathVariable String courseName) {
        return courseService.getCourseByName(courseName); // Searching by course name
    }

    // Update a course
    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable Long courseId, @RequestBody Course course) {
        course.setId(courseId);  // Ensure correct ID is set
        return courseService.updateCourse(course);
    }

    // Delete a course
    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
