package org.CFT.client;

public class FailedToUpdateProjectEmployeeException extends Throwable {
    @Override
    public String getMessage(){
        return "Could not update project employee.";
    }
}
