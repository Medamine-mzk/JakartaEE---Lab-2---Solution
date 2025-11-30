package lab2;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AddTodo")
public class AddTodoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskName = request.getParameter("taskName");

        HttpSession session = request.getSession(true); // Create a new session if not exists
        ArrayList<String> todoList = (ArrayList<String>) session.getAttribute("todoList");
        if (todoList == null) {
            todoList = new ArrayList<>();
            session.setAttribute("todoList", todoList);
        }

        todoList.add(taskName);
        session.setAttribute("todoList",todoList);
        response.setContentType("text/html");
        response.getWriter().println("The task has been added to the list.<br>");
        response.getWriter().println("<a href='index_1.html'>Back to Home</a>");

    }
}
