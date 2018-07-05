package by.practice.todo.servlet;

import by.practice.todo.repository.ProjectRepository;
import by.practice.todo.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/addprojectform")
public class AddProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addprojectform.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String projectName = request.getParameter("project_name");
        ProjectRepository projectRepository = new ProjectRepository();
        projectRepository.addProject(projectName);

        request.getRequestDispatcher("addprojectform.jsp").forward(request, response);

    }
}
