package org.CFT.cli;

public class Project {
    private int ID;
    private int client_id;
    private String Name;
    private double Value;
    private int tech_lead_id;

    public int getTech_lead_id() {
        return tech_lead_id;
    }

    public void setTech_lead_id(int tech_lead_id) {
        this.tech_lead_id = tech_lead_id;
    }

    public Project(int ID, int client_id, String name, double value, int tech_lead_id) {
        setID(ID);
        setName(name);
        setValue(value);
        setClient_ID(client_id);
        setTech_lead_id(tech_lead_id);
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

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    public int getClient_ID() {
        return client_id;
    }

    public void setClient_ID(int client_id) {
        this.client_id = client_id;
    }
}
