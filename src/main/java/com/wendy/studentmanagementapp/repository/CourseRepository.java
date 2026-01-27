package com.wendy.studentmanagementapp.repository;

import com.wendy.studentmanagementapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
}
