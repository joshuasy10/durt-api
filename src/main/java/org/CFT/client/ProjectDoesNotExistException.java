package org.CFT.client;

public class ProjectDoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "A project with that id does not exist";
    }

}
