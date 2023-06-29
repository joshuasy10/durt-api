package org.CFT.client;

public class FailedToDeleteClientException extends Exception {
    @Override
    public String getMessage(){
        return "Could not delete client.";
    }
}
