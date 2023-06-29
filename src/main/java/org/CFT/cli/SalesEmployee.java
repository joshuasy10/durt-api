package org.CFT.cli;

public class SalesEmployee extends Employee {
    private int id;
    private String name;
    private double salary;
    private String national_insurance_number;
    private String bank_account_number;
    private float commission_rate;

    public SalesEmployee(int id, String name, double salary, String national_insurance_number, String bank_account_number, float commission_rate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.national_insurance_number = national_insurance_number;
        this.bank_account_number = bank_account_number;
        this.commission_rate = commission_rate;
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

    public String getNat_insurance_number() {
        return national_insurance_number;
    }

    public void setNat_insurance_number(String national_insurance_number) {
        this.national_insurance_number = national_insurance_number;
    }

    public String getBank_account_number() {
        return bank_account_number;
    }

    public void setBank_account_number(String bank_account_number) {
        this.bank_account_number = bank_account_number;
    }

    public float getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(float commission_rate) {
        this.commission_rate = commission_rate;
    }
}
