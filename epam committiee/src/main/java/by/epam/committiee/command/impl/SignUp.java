package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;

public class SignUp implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request){
        String response;
        String login = request.getParameter(RequestParameters.LOGIN);
        String password = request.getParameter(RequestParameters.PASSWORD);
        String email = request.getParameter(RequestParameters.EMAIL);
        String surname = request.getParameter(RequestParameters.SURNAME);
        String name = request.getParameter(RequestParameters.NAME);
        String patronymic = request.getParameter(RequestParameters.PATRONYMIC);
        String passportNumber = request.getParameter(RequestParameters.PASSPORT_NUMBER);
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        AccountService accountService = serviceWarehouse.getAccountService();
        try {
            if(accountService.signUp(surname, name, patronymic, passportNumber, login,password,email)) {
                response = PathPage.HOME;
            }else{
                response = PathPage.LOGIN;
            }
        } catch (ServiceException ex){
            response = PathPage.LOGIN;
        }
        return response;
    }
}