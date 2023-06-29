package org.CFT.client;

public class FailedToDeleteSalesEmployeeException extends Exception {
    @Override
    public String getMessage(){
        return "Could not sales employee client.";
    }
}
