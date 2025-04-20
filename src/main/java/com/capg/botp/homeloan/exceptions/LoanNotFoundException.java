package com.capg.botp.homeloan.exceptions;

public class LoanNotFoundException extends RuntimeException{

    public LoanNotFoundException(String message){
        super(message);
    }
}
