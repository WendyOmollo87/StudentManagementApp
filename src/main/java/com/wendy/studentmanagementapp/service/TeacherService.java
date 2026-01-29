package com.wendy.studentmanagementapp.service;

import com.wendy.studentmanagementapp.model.Teacher;
import com.wendy.studentmanagementapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    // Save a new teacher
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Get a teacher by ID
    public Optional<Teacher> getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId);
    }

    // Delete a teacher
    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    // Update a teacher
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
