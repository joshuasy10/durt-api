package org.CFT.client;

public class FailedToGetProjectEmployeeException extends Exception {
    @Override
    public String getMessage(){
        return "Failed to get project employee from the database";
    }

}
