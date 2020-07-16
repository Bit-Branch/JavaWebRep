package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.entity.Faculty;
import by.epam.committiee.entity.Role;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.FacultyService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowFaculties implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        FacultyService facultyService = serviceWarehouse.getFacultyService();

            try {
                List<Faculty> faculties = facultyService.findAll();
                request.setAttribute(RequestParameters.FACULTIES, faculties);
                page = PathPage.FACULTIES;
            }catch (ServiceException e){
                page = PathPage.HOME;
            }
        return page;
    }
}
