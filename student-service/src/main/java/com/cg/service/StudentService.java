package com.cg.service;

import com.cg.dto.StudentRequest;
import com.cg.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(StudentRequest studentRequest);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(Long id, StudentRequest studentRequest);

    String deleteStudent(Long id);
}
