package by.practice.todo.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Task {
    private long id;
    private String description;
    private boolean completed;
    private Date createdDate;
    private long projectId;
    private Period period;

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
        return String.format("%s;%s;%s;%s", description, isCompleted(), dateFormatted(),period);
    }

    private String isCompleted() {
        return completed ? "completed" : "not completed";
    }


}
