package by.epam.tagtask.servlet;

import by.epam.tagtask.entity.VendorMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/revenue"})
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String REVENUE_PAGE = "/jsp/revenue.jsp";


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        VendorMap map = new VendorMap();
        request.setAttribute("rw", map);
        request.getRequestDispatcher(REVENUE_PAGE).forward(request, response);
    }

}