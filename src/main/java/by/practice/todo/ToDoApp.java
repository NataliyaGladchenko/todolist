package by.practice.todo;

import java.sql.SQLException;
import java.util.List;

import by.practice.todo.repository.ProjectRepository;
import by.practice.todo.model.Project;
import by.practice.todo.model.Task;
import by.practice.todo.repository.TaskRepository;

public class ToDoApp {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    private ToDoApp() {
        this.projectRepository = new ProjectRepository();
        this.taskRepository = new TaskRepository();
    }

    private void demo() throws SQLException {
        List<Project> projects = projectRepository.getAllProjects();

        for (Project project : projects) {
            long projectId = project.getId();
            List<Task> tasks = taskRepository.getTasksByProjectId(projectId);
            project.setTasks(tasks);
           ;
        }

        for (Project project : projects) {
            long projectId = project.getId();
            for (Task task : project.getTasks()) {
                if (task.getId()%2==0) {
                    taskRepository.complete(task.getId());
                }
            }
            project.setTasks(taskRepository.getTasksByProjectId(projectId));
            project.printProject();
        }
    }

    public static void main(String[] args) throws SQLException {
        new ToDoApp().demo();
    }
}
