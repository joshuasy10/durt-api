package org.CFT.cli;

public class Client {

    public Client(int id, String name, String address, String phone_number, int sales_employee_id){
        setID(id);
        setName(name);
        setAddress(address);
        setPhone_Number(phone_number);
        setSales_Employee_ID(sales_employee_id);
    }
    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
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

    private int ID;
    private String Name;
    private String Address;
    private String Phone_Number;
    private int Sales_Employee_ID;
}
