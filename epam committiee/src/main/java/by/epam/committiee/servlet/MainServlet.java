package by.epam.committiee.servlet;

import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.pool.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/main", "/register", "/login"})
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        processRequest(request);
        request.getRequestDispatcher(PathPage.LOGIN).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        processRequest(request);
        response.sendRedirect(request.getHeader(RequestParameters.ORIGIN)
                + PathPage.ROOT + PathPage.HOME);
    }

    protected void processRequest(HttpServletRequest request)
            throws ServletException, IOException {
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().close();
    }
}