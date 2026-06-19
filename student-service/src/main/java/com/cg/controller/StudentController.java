package com.cg.controller;

import com.cg.dto.StudentRequest;
import com.cg.dto.StudentResponse;
import com.cg.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/greet")
    public String greet(){
        return "Hello, Welcome to ......";
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest) {
        StudentResponse student = studentService.createStudent(studentRequest);

        URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("api/v1/student/{id}")
                    .buildAndExpand(student.id())
                    .toUri();

        return ResponseEntity.created(location).body(student);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        List<StudentResponse> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }
}
