package org.CFT.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Project_Dao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();
    public List<Project> getAllProjects() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT id, client_id, name, value FROM `projects`");

        List<Project> projectList = new ArrayList<>();

        while (rs.next()) {
            Project project = new Project(
                    rs.getInt("id"),
                    rs.getInt("client_id"),
                    rs.getString("name"),
                    rs.getDouble("value")
            );

            projectList.add(project);
        }

        return projectList;
    }
}
