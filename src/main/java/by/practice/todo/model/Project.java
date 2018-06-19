package by.practice.todo.model;

import java.util.List;

public class Project {
    private long id;
    private String projectName;
    private List<Task> tasks;

    public Project(long id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return projectName;
    }

    public void printProject() {
        System.out.println(projectName );
        if (tasks != null) {
            System.out.println("The tasks of this project:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
