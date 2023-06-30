package org.CFT.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.units.qual.C;

public class ProjectRequest {
    private int client_id;
    private String name;
    private double value;
    private int tech_lead_id;

    public int getTech_lead_id() {
        return tech_lead_id;
    }

    public void setTech_lead_id(int tech_lead_id) {
        this.tech_lead_id = tech_lead_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        value = value;
    }

    public int getClient_ID() {
        return client_id;
    }

    public void setClient_ID(int client_ID) {
        client_id = client_ID;
    }

    @JsonCreator
    public ProjectRequest(
            @JsonProperty("client_id")int client_id,
            @JsonProperty("name")String name,
            @JsonProperty("value")double value,
            @JsonProperty("lead_employee_id")int tech_lead_id) {
        this.client_id = client_id;
        this.name = name;
        this.value = value;
        this.tech_lead_id = tech_lead_id;
    }
}
