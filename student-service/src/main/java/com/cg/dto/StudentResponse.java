package com.cg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record StudentResponse(

        Long id,

        String firstName,

        String lastName,

        String email,

        @JsonProperty("address")
       AddressResponse addressResponse
) {
}

