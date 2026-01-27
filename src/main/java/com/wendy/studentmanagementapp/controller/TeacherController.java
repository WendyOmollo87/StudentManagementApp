package com.wendy.studentmanagementapp.controller;

import com.wendy.studentmanagementapp.model.Teacher;
import com.wendy.studentmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // Get all teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    // Get a teacher by ID
    @GetMapping("/{teacherId}")
    public Optional<Teacher> getTeacherById(@PathVariable Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    // Add a new teacher along with a course by course name
    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher); // Save teacher with associated course
    }

    // Update teacher
    @PutMapping("/{teacherId}")
    public Teacher updateTeacher(@PathVariable Long teacherId, @RequestBody Teacher teacher) {
        teacher.setId(teacherId);  // Ensure teacher ID is set for update
        return teacherService.updateTeacher(teacher);
    }

    // Delete teacher
    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
}
