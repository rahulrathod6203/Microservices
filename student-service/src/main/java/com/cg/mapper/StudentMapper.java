package com.cg.mapper;

import com.cg.dto.AddressResponse;
import com.cg.dto.StudentRequest;
import com.cg.dto.StudentResponse;
import com.cg.model.Student;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentMapper {

    public Student toEntity(StudentRequest request){

       return Student.builder()
               .firstName(request.firstName())
               .lastName(request.lastName())
               .email(request.email())
//               .addressId(request.addressId())
               .build();
    }

    public StudentResponse toResponse(Student student, AddressResponse addressResponse){
        return StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .addressResponse(addressResponse)
                .build();
    }
}
