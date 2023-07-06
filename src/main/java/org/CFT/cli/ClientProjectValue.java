package org.CFT.cli;

public class ClientProjectValue {
    private String clientName;

    private double value;

    public ClientProjectValue(String clientName, double value) {
        setValue(value);
        setClientName(clientName);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
