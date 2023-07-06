package org.CFT.db;

import org.CFT.cli.Project;
import org.CFT.cli.ProjectRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();
    public List<Project> getAllProjects() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT id, client_id, name, value, lead_employee_id FROM `projects`");

        List<Project> projectList = new ArrayList<>();

        while (rs.next()) {
            Project project = new Project(
                    rs.getInt("id"),
                    rs.getInt("client_id"),
                    rs.getString("name"),
                    rs.getDouble("value"),
                    rs.getInt("lead_employee_id")
            );

            projectList.add(project);
        }

        return projectList;
    }

    public Project getProjectByID(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT id, client_id, name, value, lead_employee_id FROM `projects` " +
                "WHERE id = " + id);

        List<Project> projectList = new ArrayList<>();

        while (rs.next()) {
            return new Project(
                    rs.getInt("id"),
                    rs.getInt("client_id"),
                    rs.getString("name"),
                    rs.getDouble("value"),
                    rs.getInt("lead_employee_id")
            );
        }

        return null;
    }

    public int createProject(ProjectRequest project) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO `projects`(client_id, name, value, lead_employee_id) VALUES (?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, project.getClient_ID());
        st.setString(2, project.getName());
        st.setDouble(3, project.getValue());
        st.setInt(4, project.getTech_lead_id());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }

    public void updateProject(int id, ProjectRequest project) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE `projects` SET client_id = ?, name = ?, value = ?, lead_employee_id = ? WHERE id = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, project.getClient_ID());
        st.setString(2, project.getName());
        st.setDouble(3, project.getValue());
        st.setInt(4, project.getTech_lead_id());
        st.setInt(5, id);

        st.executeUpdate();
    }

    public void deleteProject(int id) throws SQLException {
        try (Connection c = databaseConnector.getConnection()){
            String deleteStatement = "DELETE FROM projects WHERE id = ?";

            PreparedStatement st = c.prepareStatement(deleteStatement);

            st.setInt(1, id);

            st.executeUpdate();
        }
    }
}
