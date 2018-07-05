package by.practice.todo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects", uniqueConstraints = {@UniqueConstraint(columnNames = {"project_id"})})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false, unique = true)
    private long id;

    @Column(name = "project_name")
    private String projectName;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Task.class, mappedBy = "projectId")
    private List<Task> tasks;

    public Project() {
    }

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
        return projectName + "\n" + tasks;

    }


}
