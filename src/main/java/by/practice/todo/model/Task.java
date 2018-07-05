package by.practice.todo.model;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "tasks", uniqueConstraints = {@UniqueConstraint(columnNames = {"task_id"})})
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false, unique = true)
    private long id;
    @Column(name = "description")
    private String description;
    @Column(name = "completed")
    private boolean completed;
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "project_id")
    private long projectId;

    @Column(name = "period")
    @Enumerated(EnumType.STRING)
    private Period period;


    public Task() {
    }

    public Task(long id, String description, boolean completed, Date createdDate, long projectId, Period period) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.createdDate = createdDate;
        this.projectId = projectId;
        this.period = period;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    private String dateFormatted() {
        SimpleDateFormat dateFormater = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormater.format(createdDate);
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", description, isCompleted(), dateFormatted(), period);
    }

    private String isCompleted() {
        return completed ? "completed" : "uncompleted";
    }


}
