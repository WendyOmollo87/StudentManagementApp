package com.wendy.studentmanagementapp.repository;

import com.wendy.studentmanagementapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom query methods (if needed)
}
