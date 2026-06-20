package com.cg.dto;

import jakarta.persistence.Column;

public record StudentRequest(


        String firstName,

        String lastName,

        String email,

        AddressRequest addressRequest

) {
}
