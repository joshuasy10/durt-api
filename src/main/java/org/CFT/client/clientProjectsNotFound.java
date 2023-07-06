package org.CFT.client;

public class clientProjectsNotFound extends Exception {
    @Override
    public String getMessage()
    {
        return "can't find client projects";
    }
}
