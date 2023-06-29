package org.CFT.cli;

public class DeliveryEmployee extends Employee {
    private int id;
    private String name;
    private double salary;
    private String national_insurance_number;
    private String bank_account_number;

    public DeliveryEmployee(int id, String name, double salary, String national_insurance_number, String bank_account_number) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.national_insurance_number = national_insurance_number;
        this.bank_account_number = bank_account_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNational_insurance_number() {
        return national_insurance_number;
    }

    public void setNational_insurance_number(String nat_insurance_number) {
        this.national_insurance_number = nat_insurance_number;
    }

    public String getBank_account_number() {
        return bank_account_number;
    }

    public void setBank_account_number(String bank_account_number) {
        this.bank_account_number = bank_account_number;
    }
}
