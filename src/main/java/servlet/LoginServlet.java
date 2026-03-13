package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(("student1".equals(username) && "pass1".equals(password)) ||
           ("student2".equals(username) && "pass2".equals(password))) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);

            response.sendRedirect("DashboardServlet");

        } else {

            response.sendRedirect("index.html");

        }
    }
}