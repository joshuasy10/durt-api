package org.CFT.client;

public class FailedToCreateDeliveryEmployeeException extends Exception {
    @Override
    public String getMessage(){
        return "Could not create delivery employee.";
    }
}
