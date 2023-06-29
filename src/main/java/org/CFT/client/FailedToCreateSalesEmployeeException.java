package org.CFT.client;

public class FailedToCreateSalesEmployeeException extends Exception {
    @Override
    public String getMessage(){
        return "Could not create sales employee.";
    }
}
