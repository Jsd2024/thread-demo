package com.capg.botp.homeloan.exceptions;

public class CustomerAlreadyRegisteredException extends RuntimeException {

    public CustomerAlreadyRegisteredException(String message) {
        super(message);
    }
}
