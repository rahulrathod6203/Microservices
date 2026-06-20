package com.cg.dto;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record AddressResponse(

        Long id,

        String street,

        String city,

        String pinCode,

        String state,

        Long studentId
) {
}
