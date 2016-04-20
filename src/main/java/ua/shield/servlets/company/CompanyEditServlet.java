package ua.shield.servlets.company;

import ua.shield.models.Company;
import ua.shield.store.company.CompanyCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sa on 08.04.16.
 */
public class CompanyEditServlet extends HttpServlet {
    private final CompanyCache COMPANY_CACHE = CompanyCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        req.setAttribute("company", COMPANY_CACHE.getBeenById(uid));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/company/CompanyEdit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
         /*COMPANY_CACHE.saveCompanyById(
                new Company(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        req.getParameter("fullName")
                )
        );*/
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/company/view"));
    }
}
