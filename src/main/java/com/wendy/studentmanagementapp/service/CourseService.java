package com.wendy.studentmanagementapp.service;

import com.wendy.studentmanagementapp.model.Course;
import com.wendy.studentmanagementapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Save a new course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    // Get a course by ID
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    // Get a course by name
    public Course getCourseByName(String courseName) {
        return courseRepository.findByName(courseName); // Ensure that this method is present in the repository
    }

    // Update a course
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    // Delete a course
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
