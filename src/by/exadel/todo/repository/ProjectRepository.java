package by.exadel.todo.repository;


import by.exadel.todo.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    public ProjectRepository() {
    }

    public List<Project> getAllProjects() throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM projects");
        List<Project> projects = new ArrayList<>();
        while (result.next()) {
            Project project = new Project(result.getLong("project_id"), result.getString("project_name"));
            projects.add(project);
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return projects;
    }
}
