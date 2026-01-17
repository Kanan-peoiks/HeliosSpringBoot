package com.example.heliosspringboot.homeworkTask.controller;

import com.example.heliosspringboot.homeworkTask.service.CourseRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registrations")
public class CourseRegistrationController {

    private final CourseRegistrationService service;

    public CourseRegistrationController(CourseRegistrationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {

        service.registerStudentToCourse(studentId, courseId);
        return ResponseEntity.ok("Student registered successfully");
    }
}

