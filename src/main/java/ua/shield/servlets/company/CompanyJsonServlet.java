package ua.shield.servlets.company;


import com.google.gson.Gson;
import ua.shield.models.Company;
import ua.shield.store.company.CompanyCache;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by sa on 08.04.16.
 */
@WebServlet("/company/view/json")
public class CompanyJsonServlet extends HttpServlet {
    private final CompanyCache COMPANY_CACHE = CompanyCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        if (req.getParameter("uid") != null) {
            Company company = COMPANY_CACHE.getBeenById(Integer.parseInt(req.getParameter("uid")));
            resp.getWriter().write(gson.toJson(company));
        } else {
            resp.getWriter().write(gson.toJson(COMPANY_CACHE.getBeenList()));
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        COMPANY_CACHE.close();
    }

    private class Test {
        private String name = "test";
        int age = 15;
    }
}
