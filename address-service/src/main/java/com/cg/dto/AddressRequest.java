package com.cg.dto;

import jakarta.persistence.Column;

public record AddressRequest(


        String street,

        String city,

        String pinCode,

        String state,

        Long customerId
) {
}
