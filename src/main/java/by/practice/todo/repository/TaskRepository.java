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

    public List<Task> getTasks() {
        Session session = getSessionFactory().openSession();
        List<Task> tasks = session.createQuery("FROM Task").list();
        return tasks;
    }

    public void complete(long taskId) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("update Task set completed = :completed" +
                " where id = :id");
        query.setParameter("completed", true);
        query.setParameter("id", taskId);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void uncomplete(long taskId) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("update Task set completed = :completed" +
                " where id = :id");
        query.setParameter("completed", false);
        query.setParameter("id", taskId);
        query.executeUpdate();
        session.getTransaction().commit();
    }


    public void addTask(String projectName, String description, Boolean completed, Date createdDate, String period) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select id from Project  where projectName=?");
        query.setParameter(0,projectName);
        Long projectId = (long)((org.hibernate.query.Query) query).uniqueResult();
        Task task = new Task();
        task.setDescription(description);
        task.setCompleted(completed);
        task.setProjectId(projectId);
        task.setCreatedDate(createdDate);
        task.setPeriod(Period.valueOf(period));
        session.save(task);
        session.getTransaction().commit();
        session.close();


    }
}
