package org.CFT.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Client_Dao {
//    DatabaseConnector databaseConnector = new DatabaseConnector();
//    public List<Client> getAllClients() throws SQLException {
//        Connection c = databaseConnector.getConnection();
//        Statement st = c.createStatement();
//
//        ResultSet rs = st.executeQuery("SELECT id, name, address, phone FROM `clients`");
//
//        List<Client> clientList = new ArrayList<>();
//
//        while (rs.next()) {
//            Client client = new Client(
//                    rs.getInt("id"),
//                    rs.getString("name"),
//                    rs.getString("address"),
//                    rs.getString("phone")
//            );
//
//            clientList.add(client);
//        }
//
//        return clientList;
//    }
}
