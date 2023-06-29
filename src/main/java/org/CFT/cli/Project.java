package org.CFT.cli;

public class Project {
    private int ID;
    private String Name;
    private int Value;
    private int Client_ID;

    public Project(int ID, String name, int value, int client_ID) {
        setID(ID);
        setName(name);
        setValue(value);
        setClient_ID(client_ID);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public int getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(int client_ID) {
        Client_ID = client_ID;
    }
}
