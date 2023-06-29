package org.CFT.client;

public class FailedToDeleteProjectException extends Exception {
    @Override
    public String getMessage(){
        return "Could not delete project.";
    }
}
