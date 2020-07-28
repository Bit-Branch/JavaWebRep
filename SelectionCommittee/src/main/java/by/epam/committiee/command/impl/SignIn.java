package by.epam.committiee.command.impl;



import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Role;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.resource.MessageManager;
import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class SignIn implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();
        String login = request.getParameter(RequestParameters.LOGIN);
        String password = request.getParameter(RequestParameters.PASSWORD);
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        AccountService accountService = serviceWarehouse.getAccountService();
        if (accountService.signIn(login, password)) {
            try {
                long id = accountService.receiveID(login, password);
                Account account = accountService.findById(id);
                request.setAttribute(RequestParameters.LOGIN, login);
                request.setAttribute(RequestParameters.ROLE, account.getRole());
                session.setAttribute(RequestParameters.ROLE, account.getRole());
                session.setAttribute(RequestParameters.ID, id);
                session.setAttribute(RequestParameters.LOGIN,login);
                byte[] fileContent = Files.readAllBytes(account.getImage().toPath());
                session.setAttribute(RequestParameters.IMAGE, Base64.getEncoder().encodeToString(fileContent));
                page = PathPage.HOME;
            }catch (ServiceException | IOException e){
                page = PathPage.LOGIN;
            }
        } else {
            request.setAttribute(RequestParameters.ERROR_MESSAGE, MessageManager.getProperty("message.cantLogIn"));
            page = PathPage.LOGIN;
        }
        return page;
    }

}
