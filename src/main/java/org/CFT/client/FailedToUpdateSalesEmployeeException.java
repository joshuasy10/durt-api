package org.CFT.client;

public class FailedToUpdateSalesEmployeeException extends Throwable {
    @Override
    public String getMessage(){
        return "Could not update project.";
    }
}
