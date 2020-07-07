package by.epam.committiee.service;


import by.epam.committiee.entity.Account;
import by.epam.committiee.exception.ServiceException;

public interface AccountService extends Service<Account> {
    boolean signIn(String login, String password);
    boolean signUp(String login, String password, String email) throws ServiceException;
}