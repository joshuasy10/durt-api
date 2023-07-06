package org.CFT.core;

import org.CFT.cli.ClientRequest;

public class ClientValidator {
    public String isValidClient(ClientRequest client) {
        if(client.getName().length() > 50) {
            return "Client name should be under 50 characters.";
        }
        if(client.getAddress().length() > 255) {
            return "Client address should be under 255 characters.";
        }
        if(client.getPhoneNumber().length() != 11) {
            return "Please enter a valid phone number.";
        }
        return null;
    }
}
