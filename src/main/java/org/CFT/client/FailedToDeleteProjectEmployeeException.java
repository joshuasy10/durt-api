package org.CFT.client;

public class FailedToDeleteProjectEmployeeException extends Exception {
    @Override
    public String getMessage(){
        return "Could not delete project employee client.";
    }
}
