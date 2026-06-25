package com.cg.service;

import com.cg.dto.CustomerRequest;
import com.cg.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createStudent(CustomerRequest customerRequest);

    List<CustomerResponse> getAllStudents();

    CustomerResponse getStudentById(Long id);

    CustomerResponse updateStudent(Long id, CustomerRequest customerRequest);

    String deleteStudent(Long id);
}
