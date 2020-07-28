package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Address;
import by.epam.committiee.entity.Specialty;
import by.epam.committiee.entity.User;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.AddressService;
import by.epam.committiee.service.SpecialtyService;
import by.epam.committiee.service.UserService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseUser implements ActionCommand {
        @Override
        public String execute(HttpServletRequest request, HttpServletResponse response) {
            String page;
            ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
            AccountService accountService = serviceWarehouse.getAccountService();
            UserService userService = serviceWarehouse.getUserService();
            AddressService addressService = serviceWarehouse.getAddressService();
            long accountId = Long.parseLong(request.getAttribute(RequestParameters.ID).toString());
            try {
                Account account = accountService.findById(accountId);
                User user = userService.findById(accountId);
                Address address = addressService.findByUserId(accountId);

                request.setAttribute(RequestParameters.ACCOUNT, account);
                request.setAttribute(RequestParameters.USER,user);
                request.setAttribute(RequestParameters.ADDRESS,address);
                page = PathPage.EDIT_INFO;
            }catch (ServiceException e){
                page = PathPage.HOME;
            }
            return page;
        }
}
