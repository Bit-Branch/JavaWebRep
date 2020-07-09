package by.epam.committiee.command.impl;



import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.entity.Role;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignIn implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        String response;
        HttpSession session = request.getSession();
        String login = request.getParameter(RequestParameters.LOGIN);
        String password = request.getParameter(RequestParameters.PASSWORD);
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        AccountService accountService = serviceWarehouse.getAccountService();
        if (accountService.signIn(login, password)) {
            try {
                Role role = accountService.receiveRole(login, password);
                request.setAttribute(RequestParameters.LOGIN, login);
                request.setAttribute(RequestParameters.ROLE, role);
                session.setAttribute(RequestParameters.ROLE, role);
                response = PathPage.HOME;
            }catch (ServiceException e){
                response = PathPage.LOGIN;
            }
        } else {
            response = PathPage.LOGIN;
        }
        return response;
    }

}
