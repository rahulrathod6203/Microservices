package com.cg.exception;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String message) {
        super(message);
    }
}
