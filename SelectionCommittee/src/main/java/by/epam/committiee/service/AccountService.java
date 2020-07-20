package by.epam.committiee.service;


import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Role;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.exception.ServiceException;

import java.util.List;

public interface AccountService extends Service<Account> {
    boolean signIn(String login, String password);

    boolean signUp(String surname, String name, String patronymic,
                   String passportNumber, String login, String password,
                   String email) throws ServiceException;

    Role receiveRole(String login, String password) throws ServiceException;

}