package by.epam.committiee.controller.filter;

import by.epam.committiee.constant.RequestConsts;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebFilter(filterName = "locale")
public class LocaleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String lang = req.getParameter(RequestConsts.LANG);
        String cntr = req.getParameter(RequestConsts.COUNTRY);

        Locale locale = (lang != null && cntr != null)
                ? new Locale(lang, cntr)
                : Locale.getDefault();
        res.setLocale(locale);
        req.getSession().setAttribute(RequestConsts.LOCALE, locale);
        res.sendRedirect(req.getHeader(RequestConsts.REFERER));
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}

