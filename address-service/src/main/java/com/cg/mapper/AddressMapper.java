package com.cg.mapper;

import com.cg.dto.AddressRequest;
import com.cg.dto.AddressResponse;
import com.cg.model.Address;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressMapper {

    public Address toEntity(AddressRequest request){

       return Address.builder()
               .street(request.street())
               .city(request.city())
               .pinCode(request.pinCode())
               .state(request.state())
               .build();
    }

    public AddressResponse toResponse(Address address){
        return AddressResponse.builder()
                .id(address.getAddressId())
                .street(address.getStreet())
                .city(address.getCity())
                .pinCode(address.getPinCode())
                .state(address.getState())
                .build();
    }
}
