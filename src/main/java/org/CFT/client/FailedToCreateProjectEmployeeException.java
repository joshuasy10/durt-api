package org.CFT.client;

public class FailedToCreateProjectEmployeeException extends Exception {
    @Override
    public String getMessage(){
        return "Could not create project employee.";
    }
}
