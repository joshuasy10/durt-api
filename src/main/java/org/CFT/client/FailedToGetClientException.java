package org.CFT.client;

public class FailedToGetClientException extends Exception{
    @Override
    public String getMessage(){
        return "Failed to get client from the database";
    }

}
