package by.practice.todo.servlet;

import by.practice.todo.model.Project;
import by.practice.todo.repository.ProjectRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ProjectListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProjectRepository projectRepository = new ProjectRepository();

        List<Project> projects = null;
        try {
            projects = projectRepository.getAllProjects();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("projects", projects);

        req.getRequestDispatcher("projectlist.jsp").forward(req, resp);
    }

}