package org.CFT.client;

public class FailedClientValue extends Exception {
    @Override
    public String getMessage()
    {
        return "failed Query";
    }
}
