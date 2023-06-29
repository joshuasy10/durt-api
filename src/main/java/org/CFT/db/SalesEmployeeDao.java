package org.CFT.db;

import org.CFT.cli.SalesEmployee;
import org.CFT.cli.SalesEmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesEmployeeDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT id, name, salary, national_insurance_number, bank_account_number, commission_rate FROM SalesEmployees;");

        List<SalesEmployee> sales_employee_list = new ArrayList<>();

        while (rs.next()) {
            SalesEmployee sales_employee = new SalesEmployee (
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"),
                    rs.getString("national_insurance_number"),
                    rs.getString("bank_account_number"),
                    rs.getFloat("commission_rate")
            );

            sales_employee_list.add(sales_employee);
        }
        return sales_employee_list;
    }
    public SalesEmployee getSalesEmployeeById(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT id, name, salary, national_insurance_number, bank_account_number, commission_rate" +
                " FROM SalesEmployees WHERE id=" + id);

        while (rs.next()) {
            return new SalesEmployee (
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"),
                    rs.getString("national_insurance_number"),
                    rs.getString("bank_account_number"),
                    rs.getFloat("commission_rate")
            );
        }
        return null;
    }
    public int createSalesEmployee(SalesEmployeeRequest sales_employee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO SalesEmployees (id, name, salary, national_insurance_number, bank_account_number, commission_rate) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, sales_employee.getName());
        st.setDouble(2, sales_employee.getSalary());
        st.setString(3, sales_employee.getNational_insurance_number());
        st.setString(4, sales_employee.getBank_account_number());
        st.setFloat(5, sales_employee.getCommission_rate());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
    public void updateSalesEmployee(int id, SalesEmployeeRequest sales_employee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE SalesEmployees SET name = ?, salary = ?, national_insurance_number = ?, bank_account_number = ?, commission_rate = ? WHERE id = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, sales_employee.getName());
        st.setDouble(2, sales_employee.getSalary());
        st.setString(3, sales_employee.getNational_insurance_number());
        st.setString(4, sales_employee.getBank_account_number());
        st.setFloat(5, sales_employee.getCommission_rate());
        st.setInt(6, id);

        st.executeUpdate();
    }
    public void deleteSalesEmployee (int id) throws SQLException {

        Connection c = databaseConnector.getConnection();

        String delete_statement = "DELETE FROM SalesEmployees WHERE id = ?";

        PreparedStatement st = c.prepareStatement(delete_statement);

        st. setInt (1, id);

        st.executeUpdate();
    }
}