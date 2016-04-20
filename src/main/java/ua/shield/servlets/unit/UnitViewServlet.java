package ua.shield.servlets.unit;


import ua.shield.models.Unit;
import ua.shield.store.unit.UnitCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sa on 18.04.16.
 */
public class UnitViewServlet extends HttpServlet {
    private final UnitCache UNIT_CACHE = UnitCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("uid") != null) {
            Unit unit = UNIT_CACHE.getBeenById(Integer.parseInt(req.getParameter("uid")));
            req.setAttribute("unit", unit);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/unit/UnitView.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("units", UNIT_CACHE.getBeenList());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/unit/UnitViewList.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
