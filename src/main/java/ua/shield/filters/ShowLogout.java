package ua.shield.filters;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sa on 22.04.16.
 */
public class ShowLogout implements Filter {
    FilterConfig fconfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fconfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext servletContext = fconfig.getServletContext();
        if (!servletContext.getServletContextName().equals("login")) {
            PrintWriter writer = response.getWriter();
            writer.append("logout");
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
