package by.epam.committiee.controller;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.CommandProvider;
import by.epam.committiee.constant.PathConsts;
import by.epam.committiee.dao.impl.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    private final CommandProvider provider = CommandProvider.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(PathConsts.LOGIN).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            String command = req.getParameter("command");
            ActionCommand executionCommand = provider.getCommand(command);
            String response = executionCommand.execute(req);
            req.getRequestDispatcher(response).forward(req, resp);
    }

}
