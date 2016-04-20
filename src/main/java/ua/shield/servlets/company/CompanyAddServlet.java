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
public class CompanyAddServlet extends HttpServlet {
    private final CompanyCache COMPANY_CACHE = CompanyCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("company", new Company());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/company/CompanyEdit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Company company = new Company();
        company.setName(req.getParameter("name"));
        company.setFullName(req.getParameter("fullname"));
        COMPANY_CACHE.addBeen(company);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/company/view"));
    }
}
