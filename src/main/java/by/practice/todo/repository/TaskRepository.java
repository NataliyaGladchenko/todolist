package by.practice.todo.repository;


import by.practice.todo.model.Period;
import by.practice.todo.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public TaskRepository() {
    }

    public List<Task> getTasksByProjectId(long projectId) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM tasks WHERE project_id = ?");
        prepareStatement.setLong(1, projectId);
        ResultSet result = prepareStatement.executeQuery();
        List<Task> tasks = new ArrayList<>();
        while (result.next()) {
            Period period= Period.THIS_WEEK;
            Task task = new Task(result.getInt("task_id"),result.getString("description"), result.getBoolean("completed"),
                    result.getDate("created_date"), result.getInt("project_id"),period.getPeriod(result.getString("period")));
            tasks.add(task);
        }
        if (prepareStatement != null) {
            prepareStatement.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return tasks;
    }

    public void complete(long taskId) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement prepareStatement = connection.prepareStatement("UPDATE tasks SET completed=1 WHERE task_id = ?");
        prepareStatement.setLong(1, taskId);
        prepareStatement.executeUpdate();

        if (prepareStatement != null) {
            prepareStatement.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void uncomplete(long taskId) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement prepareStatement = connection.prepareStatement("UPDATE tasks SET completed=0 WHERE project_id = ?");
        prepareStatement.setLong(1, taskId);
        prepareStatement.executeUpdate();

        if (prepareStatement != null) {
            prepareStatement.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

public Long figId(String projectName)throws SQLException{
    Connection connection = DataSource.getInstance().getConnection();
    Statement statement = connection.createStatement();
    PreparedStatement preparedStatement = connection.prepareStatement("select project_id from projects where project_name=?");
    preparedStatement.setString(1,projectName);
    ResultSet result = preparedStatement.executeQuery();
    result.next();
    Long projectId = (long) result.getInt("project_id");
    if (preparedStatement != null) {
        preparedStatement.close();
    }
    if (statement != null) {
        statement.close();
    }
    if (connection != null) {
        connection.close();
    }
    return projectId;


}

    public void addTask(Long projectId,String description, Date createdDate, String period) throws SQLException{
        Connection connection = DataSource.getInstance().getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement prepareStatement = connection.prepareStatement("insert into tasks (description, completed, created_date,  project_id, period) values (?, 1, ?,?,?)");
        prepareStatement.setString(1,description);
        prepareStatement.setDate(2,createdDate);
        prepareStatement.setLong(3,projectId);
        prepareStatement.setString(4,period);
        prepareStatement.executeUpdate();

        if (prepareStatement != null) {
            prepareStatement.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
