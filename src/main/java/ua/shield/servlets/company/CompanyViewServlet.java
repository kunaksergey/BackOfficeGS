package ua.shield.servlets.company;


import ua.shield.models.Company;
import ua.shield.models.Invoice;
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
public class CompanyViewServlet extends HttpServlet {
    private final CompanyCache COMPANY_CACHE = CompanyCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("uid") != null) {
            Company company = COMPANY_CACHE.getBeenById(Integer.parseInt(req.getParameter("uid")));
            req.setAttribute("company", company);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/company/CompanyView.jsp");
            dispatcher.forward(req, resp);
        } else
            req.setAttribute("companies", COMPANY_CACHE.getBeenList());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/company/CompanyViewList.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        COMPANY_CACHE.close();
    }
}
