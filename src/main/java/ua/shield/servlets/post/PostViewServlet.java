package ua.shield.servlets.post;


import ua.shield.models.Post;
import ua.shield.models.Unit;
import ua.shield.store.post.PostCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sa on 18.04.16.
 */
@WebServlet("/post/view")
public class PostViewServlet extends HttpServlet {
    private final PostCache POST_CACHE = PostCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String servletInfo = getServletInfo();

        if (req.getParameter("uid") != null) {
            Post post = POST_CACHE.getBeenById(Integer.parseInt(req.getParameter("uid")));
            req.setAttribute("post", post);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/post/PostView.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("posts", POST_CACHE.getBeenList());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/post/PostViewList.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
