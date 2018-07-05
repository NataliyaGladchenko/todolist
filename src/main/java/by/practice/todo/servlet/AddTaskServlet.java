package by.practice.todo.servlet;

import by.practice.todo.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/addtaskform")
public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addtaskform.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String projectName = request.getParameter("project_name");
        String description = request.getParameter("description");
        Boolean completed = Boolean.getBoolean(request.getParameter("completed"));
        Date createdDate = Date.valueOf(request.getParameter("created_date"));
        String period = request.getParameter("period");


        TaskRepository taskRepository = new TaskRepository();
        try {
            taskRepository.addTask( projectName, description,completed, createdDate, period);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("addtaskform.jsp").forward(request, response);

    }
}