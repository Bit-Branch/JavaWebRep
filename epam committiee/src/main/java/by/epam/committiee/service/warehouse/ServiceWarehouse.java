package by.epam.committiee.service.warehouse;

import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.impl.AccountServiceImpl;

public class ServiceWarehouse {
    private static final ServiceWarehouse instance = new ServiceWarehouse();

    private final AccountService accountService = new AccountServiceImpl();

    private ServiceWarehouse(){}

    public static ServiceWarehouse getInstance(){
        return instance;
    }

    public AccountService getAccountService() {
        return accountService;
    }
}