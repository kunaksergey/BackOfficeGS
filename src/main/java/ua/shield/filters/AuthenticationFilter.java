package ua.shield.filters;

/**
 * Created by sa on 21.04.16.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthenticationFilter implements Filter {

    //private ServletContext servletContext;
    private FilterConfig filterConfig;
    private boolean isActive = false;
    public void init(FilterConfig fConfig) throws ServletException {
        filterConfig = fConfig;
        isActive = Boolean.parseBoolean(filterConfig.getInitParameter("active").toLowerCase());
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (isActive) {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession session = req.getSession(false);
            String requestURI = req.getRequestURI();
            if (session == null && !(requestURI.endsWith("login.html") || requestURI.endsWith("login"))) {
                resp.sendRedirect("/login.html");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }


    public void destroy() {
        //close any resources here
    }

}