package com.cg.dto;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record StudentResponse(

        Long id,

        String firstName,

        String lastName,

        String email

        //Long addressId
) {
}
