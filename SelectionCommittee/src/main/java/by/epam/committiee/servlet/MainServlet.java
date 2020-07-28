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

@WebServlet(urlPatterns = {"/main", "/register", "/login","/logout","/choose_faculty",
        "/choose_specialty","/show_faculties","/profile","/my_marks","/my_specialties",
        "/edit_users","/edit_faculties","/edit_specialties","/users_list","/edit_marks",
        "/edit_info"})
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

      String page = processRequest(request,response);
        request.getRequestDispatcher(page).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

       String page = processRequest(request,response);
       response.sendRedirect(request.getContextPath() + page);
    }

    protected String processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        String commandStr = request.getParameter(RequestParameters.COMMAND_PARAMETER);
        CommandProvider commandProvider = CommandProvider.getInstance();
        ActionCommand command = commandProvider.getCommand(commandStr);
        String page = command.execute(request,response);
        request.setAttribute(RequestParameters.ERROR_MESSAGE, "");

      /*  if (page != null && !page.equals(CommandName.WRONG_REQUEST.toString())) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            page = request.getRequestURI();
            request.getSession().setAttribute("Message", MessageManager.getProperty("message.cantLogIn"));
            response.sendRedirect(request.getContextPath() + page);
        }*/

      return page;

    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().close();
    }
}