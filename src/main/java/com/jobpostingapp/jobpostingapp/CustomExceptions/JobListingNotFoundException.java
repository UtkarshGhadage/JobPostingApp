package com.jobpostingapp.jobpostingapp.CustomExceptions;

public class JobListingNotFoundException extends RuntimeException {
    public JobListingNotFoundException(String message) {
        super(message);
    }
}
