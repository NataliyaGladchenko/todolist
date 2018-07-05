package by.practice.todo.repository;


import by.practice.todo.model.Period;
import by.practice.todo.model.Project;
import by.practice.todo.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.sql.*;
import java.util.List;

public class TaskRepository {

    public TaskRepository() {
    }

    public static SessionFactory getSessionFactory() {
        StandardServiceRegistry registry;
        SessionFactory sessionFactory;
        registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;

    }

    public List<Task> getTasks() throws SQLException {
        Session session = getSessionFactory().openSession();
        List<Task> tasks = session.createQuery("FROM Task").list();
        return tasks;
    }

    public void complete(long taskId) throws SQLException {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("update Task set completed = :completed" +
                " where id = :id");
        query.setParameter("completed", true);
        query.setParameter("id", taskId);
        int result = query.executeUpdate();
    }
//
//    public void uncomplete(long taskId) throws SQLException {
//        Session session = getSessionFactory().openSession();
//        TaskRepository taskRepository = new TaskRepository();
//        List<Task> tasks = taskRepository.getTasks();
//        for (Task task : tasks) {
//            if (task.getId() == taskId) {
//                task.setCompleted(false);
//                session.save(task);
//            }
//        }
//    }



    public void addTask(String projectName, String description, Boolean completed, Date createdDate, String period) throws SQLException {
        Session session = getSessionFactory().openSession();
        Task task = new Task();
        ProjectRepository projectRepository = new ProjectRepository();
        List<Project> projects = projectRepository.getAllProjects();
        for (Project project : projects) {
            if (project.getProjectName().compareTo(projectName) == 0) {
                Long projectId = project.getId();
                task.setProjectId(projectId);
                task.setDescription(description);
                task.setCompleted(completed);
                task.setCreatedDate(createdDate);
                task.setPeriod(Period.valueOf(period));
            }
        }

        session.save(task);

        session.close();


    }
}
