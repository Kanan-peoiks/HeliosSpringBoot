package com.example.heliosspringboot.homeworkTask.repository;

import com.example.heliosspringboot.homeworkTask.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(
            value = "SELECT COUNT(*) FROM student_courses WHERE course_id = :courseId",
            nativeQuery = true
    )
    int countStudentsByCourseId(@Param("courseId") Long courseId);
}
