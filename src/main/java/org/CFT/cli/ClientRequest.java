package org.CFT.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientRequest {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public int getSales_Employee_ID() {
        return Sales_Employee_ID;
    }

    public void setSales_Employee_ID(int sales_Employee_ID) {
        Sales_Employee_ID = sales_Employee_ID;
    }

    private String Address;
    private String Phone_Number;
    private int Sales_Employee_ID;

    @JsonCreator
    public ClientRequest(
            @JsonProperty("Name") String Name,
            @JsonProperty("Address") String Address,
            @JsonProperty("Phone_Number") String Phone_Number,
            @JsonProperty("Sales_Employee_ID") int Sales_Employee_ID) {
            this.Name = Name;
            this.Address = Address;
            this.Phone_Number = Phone_Number;
            this.Sales_Employee_ID = Sales_Employee_ID;
    }
}
