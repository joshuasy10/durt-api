package org.CFT.client;

public class ClientDoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "A client with that id does not exist";
    }

}
