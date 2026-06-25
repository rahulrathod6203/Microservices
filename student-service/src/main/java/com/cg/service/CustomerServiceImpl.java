package com.cg.service;

import com.cg.dto.AddressResponse;
import com.cg.dto.CustomerRequest;
import com.cg.dto.CustomerResponse;
import com.cg.exception.CustomerNotFoundException;
import com.cg.feignClients.AddressFeignClient;
import com.cg.mapper.CustomerMapper;
import com.cg.model.Customer;
import com.cg.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper mapper;

    private final AddressFeignClient addressFeignClient;

    @Override
    public CustomerResponse createStudent(CustomerRequest customerRequest) {
        log.info("Creating STUDENT...");
        Customer customer = mapper.toEntity(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("STUDENT created, {}", savedCustomer.toString());

        log.info("Adding STUDENT address");

        AddressResponse addressResponse =
                addressFeignClient.createAddress(savedCustomer.getId(), customerRequest.addressRequest()).getBody();
        log.info("Student address added {}", addressResponse);

//        return StudentResponse.builder()
//                .id(student.getId())
//                .firstName(student.getFirstName())
//                .lastName(student.getLastName())
//                .email(student.getEmail())
//                .addressResponse(addressResponse)
//                .build();


       return mapper.toResponse(savedCustomer,addressResponse);
    }

    @Override
    public List<CustomerResponse> getAllStudents() {
        return null;
//        return studentRepository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public CustomerResponse getStudentById(Long id) {

        // retrieve Address By id from address-service
        AddressResponse addressById = addressFeignClient.getAddressById(id).getBody();
        return customerRepository.findById(id)
                .map(customer -> mapper.toResponse(customer,addressById))
                .orElseThrow(() -> new CustomerNotFoundException("Student not found with id="+id));
    }

    @Override
    public CustomerResponse updateStudent(Long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Student not found with id=" + id));

        customer.setFirstName(customerRequest.firstName());
        customer.setLastName(customerRequest.lastName());
        customer.setEmail(customerRequest.email());
//        student.setAddressId(studentRequest.addressId());

        Customer updatedCustomer = customerRepository.save(customer);

        //return mapper.toResponse(updatedStudent);
        return null;
    }

    @Override
    public String deleteStudent(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Student not found with id="+id));

        customerRepository.deleteById(id);
        return "Student with id="+id + " deleted successfully!";
    }

}
