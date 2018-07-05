package by.practice.todo;

import java.sql.SQLException;
import java.util.List;

import by.practice.todo.model.Project;
import by.practice.todo.repository.ProjectRepository;
import by.practice.todo.model.Task;
import by.practice.todo.repository.TaskRepository;

public class ToDoApp {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    public ToDoApp() {
        this.projectRepository = new ProjectRepository();
        this.taskRepository = new TaskRepository();
    }

    public void demo() throws SQLException {
        List<Project> projects = projectRepository.getAllProjects();

        taskRepository.complete(27);
        for (Project project : projects) {
            System.out.println(project);
        }


    }

    public static void main(String[] args) throws SQLException {
        new ToDoApp().demo();
    }
}
