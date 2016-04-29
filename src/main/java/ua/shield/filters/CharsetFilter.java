package ua.shield.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by sa on 21.04.16.
 */
public class CharsetFilter implements Filter {
    // кодировка
    private final String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
