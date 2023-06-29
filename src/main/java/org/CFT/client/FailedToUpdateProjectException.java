package org.CFT.client;

public class FailedToUpdateProjectException extends Throwable {
    @Override
    public String getMessage(){
        return "Could not update project.";
    }
}
