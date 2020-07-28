package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.entity.Faculty;
import by.epam.committiee.entity.Specialty;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.FacultyService;
import by.epam.committiee.service.SpecialtyService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MySpecialties implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        SpecialtyService specialtyService = serviceWarehouse.getSpecialtyService();
        try {
            List<Specialty> specialties = specialtyService.findUserSpecialties(Long.parseLong(request.getSession().getAttribute(RequestParameters.ID).toString()));
            request.setAttribute(RequestParameters.SPECIALTIES, specialties);
            request.setAttribute(RequestParameters.CREDITED_ID, 1);
            page = PathPage.MY_SPECIALTIES;
        }catch (ServiceException e){
            page = PathPage.HOME;
        }
        return page;
    }
}
