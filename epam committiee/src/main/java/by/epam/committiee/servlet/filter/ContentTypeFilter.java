package by.epam.committiee.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

public class ContentTypeFilter implements Filter {
    private String contentType;
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        contentType = filterConfig.getInitParameter("contentType");
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType(contentType);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

