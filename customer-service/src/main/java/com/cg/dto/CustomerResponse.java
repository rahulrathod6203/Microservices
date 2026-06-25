package com.cg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CustomerResponse(

        Long id,

        String firstName,

        String lastName,

        String email,

        @JsonProperty("address")
       AddressResponse addressResponse
) {
}

