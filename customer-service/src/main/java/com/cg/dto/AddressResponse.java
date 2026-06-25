package com.cg.dto;

import lombok.Builder;

@Builder
public record AddressResponse(

        Long id,

        String street,

        String city,

        String pinCode,

        String state,

        Long customerId
) {
}
