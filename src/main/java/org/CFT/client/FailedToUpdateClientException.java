package org.CFT.client;

public class FailedToUpdateClientException extends Throwable {
    @Override
    public String getMessage(){
        return "Could not update client.";
    }
}
