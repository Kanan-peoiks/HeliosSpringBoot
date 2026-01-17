package com.example.heliosspringboot.homeworkTask.repository;

import com.example.heliosspringboot.homeworkTask.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
