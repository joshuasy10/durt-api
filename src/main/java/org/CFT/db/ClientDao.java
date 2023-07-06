package org.CFT.db;

import org.CFT.cli.Client;
import org.CFT.cli.ClientRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    DatabaseConnector databaseConnector = new DatabaseConnector();
    public List<Client> getAllClients() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT id, name, address, phone, sales_employee_id FROM `clients`");

        List<Client> clientList = new ArrayList<>();

        while (rs.next()) {
            Client client = new Client(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getInt("sales_employee_id")
            );

            clientList.add(client);
        }

        return clientList;
    }

    public Client getClientByID(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT id, name, address, phone, sales_employee_id FROM `clients` " +
                "WHERE id = " + id);

        List<Client> clientList = new ArrayList<>();

        while (rs.next()) {
            return new Client(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getInt("sales_employee_id")
            );
        }

        return null;
    }

    public int createClient(ClientRequest client) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO `clients`(name, address, phone, sales_employee_id) VALUES (?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, client.getName());
        st.setString(2, client.getAddress());
        st.setString(3, client.getPhoneNumber());
        st.setInt(4, client.getSalesEmployeeId());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }

    public void updateClient(int id, ClientRequest client) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE `clients` SET name = ?, address = ?, phone_number = ?, sales_employee_id = ? WHERE id = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, client.getName());
        st.setString(2, client.getAddress());
        st.setString(3, client.getPhoneNumber());
        st.setInt(4, client.getSalesEmployeeId());
        st.setInt(5, id);

        st.executeUpdate();
    }

    public void deleteClient(int id) throws SQLException {
        try (Connection c = databaseConnector.getConnection()){
            String deleteStatement = "DELETE FROM clients WHERE id = ?";

            PreparedStatement st = c.prepareStatement(deleteStatement);

            st.setInt(1, id);

            st.executeUpdate();
        }
    }
}
