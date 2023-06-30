package org.CFT.cli;

public class SalesEmployee extends Employee {

    private float commission_rate;

    public SalesEmployee(int id, String name, double salary, String national_insurance_number, String bank_account_number, float commission_rate) {
        super(id, name, salary, national_insurance_number, bank_account_number);
        this.setCommission_rate(commission_rate);
    }

    public float getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(float commission_rate) {
        this.commission_rate = commission_rate;
    }
}
