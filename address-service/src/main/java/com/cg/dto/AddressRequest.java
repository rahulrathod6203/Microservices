package com.cg.dto;

import jakarta.persistence.Column;

public record AddressRequest(

        @Column(name = "first_name", nullable = false)
        String street,

        @Column(name = "last_name", nullable = false)
        String city,

        @Column(name = "pinCode", nullable = false)
        String pinCode,

        @Column(name = "address_id", nullable = false)
        String state
) {
}
