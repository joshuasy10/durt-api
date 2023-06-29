package org.CFT.client;

public class FailedToGetSalesEmployeeException extends Exception{
    @Override
    public String getMessage(){
        return "Failed to get sales employee from the database";
    }

}
