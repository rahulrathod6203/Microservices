package com.cg.exception;

import lombok.Builder;

import java.time.Instant;

@Builder
public record ExceptionResponse(
        Instant timeStamp,
        String errorMessage,
        String status,
        String path

) {
}
