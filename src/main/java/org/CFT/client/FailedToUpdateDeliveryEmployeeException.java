package org.CFT.client;

public class FailedToUpdateDeliveryEmployeeException extends Throwable {
    @Override
    public String getMessage(){
        return "Could not update delivery employee.";
    }
}
