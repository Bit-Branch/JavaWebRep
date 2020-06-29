package by.epam.committiee.service.factory;

import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.impl.AccountServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final AccountService accountService = new AccountServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public AccountService getAccountService() {
        return accountService;
    }
}