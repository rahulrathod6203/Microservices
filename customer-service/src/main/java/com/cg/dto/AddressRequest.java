package com.cg.dto;

public record AddressRequest(


        String street,

        String city,

        String pinCode,

        String state,

        Long customerId
) {
}
