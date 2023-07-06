package org.CFT.cli;

public class Client {

    public Client(int id, String name, String address, String phone_number, int sales_employee_id){
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNumber(phone_number);
        this.setSalesEmployeeId(sales_employee_id);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
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

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private int salesEmployeeId;
}
