package com.example.heliosspringboot.homeworkTask.service;


import com.example.heliosspringboot.homeworkTask.entities.Course;
import com.example.heliosspringboot.homeworkTask.entities.Student;
import com.example.heliosspringboot.homeworkTask.repository.CourseRepository;
import com.example.heliosspringboot.homeworkTask.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CourseRegistrationService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public CourseRegistrationService(StudentRepository studentRepository,
                                     CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void registerStudentToCourse(Long studentId, Long courseId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        int currentStudentCount =
                courseRepository.countStudentsByCourseId(courseId);

        if (currentStudentCount >= course.getMaxStudents()) {
            throw new RuntimeException("Course is full");
        }

        // artıq qeydiyyatda olmasın deyə
        if (student.getCourses().contains(course)) {
            throw new RuntimeException("Student already registered");
        }

        student.getCourses().add(course);
        studentRepository.save(student);
    }
}
