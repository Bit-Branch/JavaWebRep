package by.epam.committiee.service.warehouse;

import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.FacultyService;
import by.epam.committiee.service.impl.AccountServiceImpl;
import by.epam.committiee.service.impl.FacultyServiceImpl;

public class ServiceWarehouse {
    private static final ServiceWarehouse instance = new ServiceWarehouse();

    private final AccountService accountService = new AccountServiceImpl();

    private final FacultyService facultyService = new FacultyServiceImpl();

    private ServiceWarehouse(){}

    public static ServiceWarehouse getInstance(){
        return instance;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public FacultyService getFacultyService() {
        return facultyService;
    }
}