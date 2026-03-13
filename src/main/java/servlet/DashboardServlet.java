package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("username") == null) {
            response.sendRedirect("index.html");
            return;
        }

        List<Course> courses = new ArrayList<>();

        courses.add(new Course("101","Java Programming","Dr Silva"));
        courses.add(new Course("102","Web Development","Mr Perera"));
        courses.add(new Course("103","Database Systems","Ms Fernando"));

        request.setAttribute("courses", courses);

        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
    }
}