package by.epam.committiee.service.warehouse;

import by.epam.committiee.service.*;
import by.epam.committiee.service.impl.*;

public class ServiceWarehouse {
    private static final ServiceWarehouse instance = new ServiceWarehouse();

    private final AccountService accountService = new AccountServiceImpl();

    private final FacultyService facultyService = new FacultyServiceImpl();

    private final ResultService resultService = new ResultServiceImpl();

    private final SpecialtyService specialtyService = new SpecialtyServiceImpl();

    private final AddressService addressService = new AddressServiceImpl();

    private final UserService userService = new UserServiceImpl();

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

    public ResultService getResultService() {
        return resultService;
    }

    public SpecialtyService getSpecialtyService() {
        return specialtyService;
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public UserService getUserService() {
        return userService;
    }
}