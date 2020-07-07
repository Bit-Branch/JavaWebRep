package by.epam.committiee.command.impl;



import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;

public class SignIn implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        String response;
        String login = request.getParameter(RequestParameters.LOGIN);
        String password = request.getParameter(RequestParameters.PASSWORD);
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        AccountService accountService = serviceWarehouse.getAccountService();
        if (accountService.signIn(login, password)) {
            response = PathPage.HOME;
        } else {
            response = PathPage.LOGIN;
        }
        return response;
    }

}
