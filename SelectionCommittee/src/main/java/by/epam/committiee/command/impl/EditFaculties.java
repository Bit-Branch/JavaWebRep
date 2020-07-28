package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.entity.Faculty;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.FacultyService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditFaculties implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        FacultyService facultyService = serviceWarehouse.getFacultyService();
        try {
            List<Faculty> faculties = facultyService.findAll();
            request.setAttribute(RequestParameters.FACULTIES, faculties);
            page = PathPage.EDIT_FACULTIES;
        }catch (ServiceException e){
            page = PathPage.HOME;
        }
        return page;
    }
}

