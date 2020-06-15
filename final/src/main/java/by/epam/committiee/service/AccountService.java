package by.epam.committiee.service;

import by.epam.committiee.entity.Account;
import by.epam.committiee.exception.ServiceException;


public interface AccountService extends Service<Account> {
    Account signIn(String login, String password) throws ServiceException;
    void register(Account account) throws ServiceException;
}