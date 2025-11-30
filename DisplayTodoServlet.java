package lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DisplayTodo")
public class DisplayTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Get existing session if exists

        response.setContentType("text/html");
        response.getWriter().println("<h2>Todo List</h2>");

        if (session != null) {
            ArrayList<String> todoList = (ArrayList<String>) session.getAttribute("todoList");
            if (todoList != null && !todoList.isEmpty()) {
                response.getWriter().println("<p>Number of tasks: " + todoList.size() + "</p>");
                response.getWriter().println("<ul>");
                for (String task : todoList) {
                    response.getWriter().println("<li>" + task + "</li>");
                }
                response.getWriter().println("</ul>");
            } else {
                response.getWriter().println("<p>No tasks found.</p>");
            }
        } else {
            response.getWriter().println("<p>No session found.</p>");
        }

        response.getWriter().println("<a href='index_1.html'>Back to Home</a>");

    }
}
