package by.epam.committiee.servlet;

import by.epam.committiee.command.*;
import by.epam.committiee.entity.Account;
import by.epam.committiee.pool.ConnectionPool;
import by.epam.committiee.resource.MessageManager;

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

        processRequest(request,response);
        request.getRequestDispatcher(PathPage.LOGIN).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
        response.sendRedirect(request.getHeader(RequestParameters.ORIGIN)
                + PathPage.ROOT + PathPage.HOME);
    }

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        String commandStr = request.getParameter(RequestParameters.COMMAND_PARAMETER);
        CommandProvider commandProvider = CommandProvider.getInstance();
        ActionCommand command = commandProvider.getCommand(commandStr);
        String page = command.execute(request);

        if (!page.equals(CommandName.WRONG_REQUEST.toString())) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            page = request.getRequestURI();
            request.getSession().setAttribute("Message", MessageManager.getProperty("message.cantLogIn"));
            response.sendRedirect(request.getContextPath() + page);
        }

    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().close();
    }
}