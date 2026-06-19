package com.cg.dto;

import jakarta.persistence.Column;

public record StudentRequest(

        @Column(name = "first_name", nullable = false)
        String firstName,

        @Column(name = "last_name", nullable = false)
        String lastName,

        @Column(name = "email", nullable = false)
        String email,

        @Column(name = "address_id", nullable = false)
        Long addressId
) {
}
