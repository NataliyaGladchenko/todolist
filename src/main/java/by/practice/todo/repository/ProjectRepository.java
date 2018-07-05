package by.practice.todo.repository;


import by.practice.todo.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    public ProjectRepository() {
    }

    private static SessionFactory getSessionFactory() {
        StandardServiceRegistry registry;
        SessionFactory sessionFactory;
        registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;

    }

    public List<Project> getAllProjects() {
        Session session = getSessionFactory().openSession();
        List<Project> projects = session.createQuery("FROM Project ").list();
        session.close();

        return projects;
    }

    public void addProject(String projectName) {
        Session session = getSessionFactory().openSession();
        Project project = new Project();
        project.setProjectName(projectName);
        session.save(project);
        session.close();
    }
}
