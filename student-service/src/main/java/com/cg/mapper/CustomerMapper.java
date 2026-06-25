package com.cg.mapper;

import com.cg.dto.AddressResponse;
import com.cg.dto.CustomerRequest;
import com.cg.dto.CustomerResponse;
import com.cg.model.Customer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerMapper {

    public Customer toEntity(CustomerRequest request){

       return Customer.builder()
               .firstName(request.firstName())
               .lastName(request.lastName())
               .email(request.email())
//               .addressId(request.addressId())
               .build();
    }

    public CustomerResponse toResponse(Customer customer, AddressResponse addressResponse){
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .addressResponse(addressResponse)
                .build();
    }
}
