package com.cg.service;

import com.cg.dto.StudentRequest;
import com.cg.dto.StudentResponse;
import com.cg.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        return null;
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return List.of();
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return null;
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        return null;
    }

    @Override
    public String deleteStudent(Long id) {
        return "";
    }
}
