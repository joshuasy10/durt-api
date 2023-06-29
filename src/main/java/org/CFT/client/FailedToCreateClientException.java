package org.CFT.client;

public class FailedToCreateClientException extends Exception {
    @Override
    public String getMessage(){
        return "Could not create client.";
    }
}
