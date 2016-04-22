package ua.shield.servlets.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sa on 21.04.16.
 */
public class LoginServlet extends HttpServlet {
    private final String userID = "sa";
    private final String password = "kunak905";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get request parameters for userID and password
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        if (user.equals(userID) && pwd.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", "Sergey");
            resp.sendRedirect("/invoice/view");


        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(req, resp);
        }

    }
}
