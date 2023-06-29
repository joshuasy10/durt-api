package org.CFT.client;

public class FailedToGetProjectException extends Exception{
    @Override
    public String getMessage(){
        return "Failed to get project from the database";
    }

}
