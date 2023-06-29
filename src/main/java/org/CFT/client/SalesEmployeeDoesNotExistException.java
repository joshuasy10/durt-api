package org.CFT.client;

public class SalesEmployeeDoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "A sales employee with that id does not exist";
    }

}
