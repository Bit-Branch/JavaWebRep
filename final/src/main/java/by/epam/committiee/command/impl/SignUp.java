package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.constant.PathConsts;
import by.epam.committiee.constant.RequestConsts;
import by.epam.committiee.entity.Account;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class SignUp implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request){
        String response;
        String login = request.getParameter(RequestConsts.LOGIN);
        String password = request.getParameter(RequestConsts.PASSWORD);
        String email = request.getParameter(RequestConsts.EMAIL);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService accountService = serviceFactory.getAccountService();
        try {
            accountService.signUp(login,password,email);
            response = PathConsts.HOME;
        } catch (ServiceException ex){
            response = PathConsts.LOGIN;
        }
        return response;
    }
}