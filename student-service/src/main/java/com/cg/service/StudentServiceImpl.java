package com.cg.service;

import com.cg.dto.AddressResponse;
import com.cg.dto.StudentRequest;
import com.cg.dto.StudentResponse;
import com.cg.exception.StudentNotFoundException;
import com.cg.feignClients.AddressFeignClient;
import com.cg.mapper.StudentMapper;
import com.cg.model.Student;
import com.cg.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    private final StudentMapper mapper;

    private final AddressFeignClient addressFeignClient;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        log.info("Creating STUDENT...");
        Student student = mapper.toEntity(studentRequest);
        Student savedStudent = studentRepository.save(student);
        log.info("STUDENT created, {}",savedStudent.toString());

        log.info("Adding STUDENT address");

        AddressResponse addressResponse =
                addressFeignClient.createAddress(savedStudent.getId(), studentRequest.addressRequest()).getBody();
        log.info("Student address added {}", addressResponse);

//        return StudentResponse.builder()
//                .id(student.getId())
//                .firstName(student.getFirstName())
//                .lastName(student.getLastName())
//                .email(student.getEmail())
//                .addressResponse(addressResponse)
//                .build();


       return mapper.toResponse(savedStudent,addressResponse);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return null;
//        return studentRepository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public StudentResponse getStudentById(Long id) {

        // retrieve Address By id from address-service
        AddressResponse addressById = addressFeignClient.getAddressById(id).getBody();
        return studentRepository.findById(id)
                .map(student -> mapper.toResponse(student,addressById))
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id="+id));
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id=" + id));

        student.setFirstName(studentRequest.firstName());
        student.setLastName(studentRequest.lastName());
        student.setEmail(studentRequest.email());
//        student.setAddressId(studentRequest.addressId());

        Student updatedStudent = studentRepository.save(student);

        //return mapper.toResponse(updatedStudent);
        return null;
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id="+id));

        studentRepository.deleteById(id);
        return "Student with id="+id + " deleted successfully!";
    }

}
