package com.wendy.studentmanagementapp.repository;

import com.wendy.studentmanagementapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Custom query methods can be added here if necessary
}
