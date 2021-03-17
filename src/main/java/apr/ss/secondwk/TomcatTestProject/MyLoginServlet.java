package apr.ss.secondwk.TomcatTestProject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyLoginServlet", value = "/login")
public class MyLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String isBadLogin = request.getParameter("badlogin");
        PrintWriter pw = response.getWriter();

        pw.println("<h1>Login</h1>");
        pw.println(null != isBadLogin && isBadLogin.equals("true")? "<p style='color:red;'>Bad login</p>":"");
        pw.print("<form method='POST' action='login'>");
        pw.print("<div>");
        pw.print("<label>username: </label>");
        pw.println("<input type='text' name='username'>");
        pw.print("</div>");
        pw.print("<div>");
        pw.print("<label>password: </label>");
        pw.print("<input type='password' name='password'>");
        pw.print("</div>");
        pw.print("<button type='submit'>Login</button>");
        pw.print("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("username").equals("bermond") &&
                request.getParameter("password").equals("password123")) {
            response.sendRedirect("welcome");
        } else {
            response.sendRedirect("login?badlogin=true");
        }

    }
}
