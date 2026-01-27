package com.wendy.studentmanagementapp.service;

import com.wendy.studentmanagementapp.model.Course;
import com.wendy.studentmanagementapp.model.Teacher;
import com.wendy.studentmanagementapp.repository.CourseRepository;
import com.wendy.studentmanagementapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Save a new teacher and assign course by name
    public Teacher saveTeacher(Teacher teacher) {
        // Check if the course exists based on the course name
        Course course = courseRepository.findByName(teacher.getCourses().iterator().next().getName());
        if (course != null) {
            teacher.setCourses(Set.of(course)); // Assign the found course to the teacher
            return teacherRepository.save(teacher); // Save the teacher with the course
        } else {
            throw new RuntimeException("Course not found!");
        }
    }

    // Get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Get a teacher by ID
    public Optional<Teacher> getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId);
    }

    // Update teacher
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Delete teacher
    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
