package com.cg.dto;

public record CustomerRequest(


        String firstName,

        String lastName,

        String email,

        AddressRequest addressRequest

) {
}
