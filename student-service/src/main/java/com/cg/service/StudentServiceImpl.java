package com.cg.service;

import com.cg.dto.StudentRequest;
import com.cg.dto.StudentResponse;
import com.cg.mapper.StudentMapper;
import com.cg.model.Student;
import com.cg.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    private final StudentMapper mapper;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {

        Student student = mapper.toEntity(studentRequest);
        Student savedStudent = studentRepository.save(student);

        return mapper.toResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream().map(mapper::toResponse).toList();
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
