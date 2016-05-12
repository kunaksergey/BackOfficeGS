package ua.shield.servlets.person;

import ua.shield.models.Person;
import ua.shield.store.person.PersonCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sa on 20.04.16.
 */
@WebServlet("/person/view")
public class PersonViewServlet extends HttpServlet {
    private final PersonCache PERSON_CACHE = PersonCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("uid") != null) {
            Person person = PERSON_CACHE.getBeenById(Integer.parseInt(req.getParameter("uid")));
            req.setAttribute("person", person);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/person/PersonView.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("persons", PERSON_CACHE.getBeenList());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/person/PersonViewList.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
