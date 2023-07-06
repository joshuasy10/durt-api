package org.CFT.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientRequest {
    private String name;
    private String address;
    private String phoneNumber;
    private int salesEmployeeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
    }

    @JsonCreator
    public ClientRequest(
            @JsonProperty("name") String name,
            @JsonProperty("address") String address,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("salesEmployeeID") int salesEmployeeID) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.salesEmployeeId = salesEmployeeId;
    }
}
