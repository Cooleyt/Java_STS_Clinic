package com.caresoft.clinicapp;

public interface PHIComplaintUser {
    abstract boolean assignPin();
    
    // Expected to compare instance id with id passed in. Returns true or false.
    abstract boolean isAuthorized(Integer confirmedAuthID);
}
