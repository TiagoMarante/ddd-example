package com.api.parkingcontrol.exceptions;

public class CompanyException extends RuntimeException{
    public CompanyException(String message) { super(message); }

    public static CompanyException companyNotFound() {
        return new CompanyException("Company not found");
    }
}
