package lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DeleteTodo")
public class DeleteTodo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskOrder = Integer.parseInt(request.getParameter("taskOrder"));

        HttpSession session = request.getSession(false);
        if (session != null) {
            ArrayList<String> todoList = (ArrayList<String>) session.getAttribute("todoList");
            if (todoList != null && !todoList.isEmpty() && taskOrder >= 0 && taskOrder < todoList.size()) {
                todoList.remove(taskOrder);
            }
        }
        response.sendRedirect("DisplayTodo");
    }
}
