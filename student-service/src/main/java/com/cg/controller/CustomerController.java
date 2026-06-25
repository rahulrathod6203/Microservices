package com.cg.controller;

import com.cg.dto.CustomerRequest;
import com.cg.dto.CustomerResponse;
import com.cg.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/greet")
    public String greet(){
        return "Hello, Welcome to ...";
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createStudent(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse student = customerService.createStudent(customerRequest);

        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(student.id())
                    .toUri();

        return ResponseEntity.created(location).body(student);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllStudents() {
        List<CustomerResponse> allStudents = customerService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getStudentById(@PathVariable Long id) {
        CustomerResponse studentById = customerService.getStudentById(id);
        return ResponseEntity.ok(studentById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateStudent(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.updateStudent(id, customerRequest);
        return ResponseEntity.accepted().body(customerResponse);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent( @PathVariable Long id) {
        return customerService.deleteStudent(id);
    }


}
