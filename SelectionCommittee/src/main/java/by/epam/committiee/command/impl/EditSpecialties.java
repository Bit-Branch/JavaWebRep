package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.entity.Specialty;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.SpecialtyService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditSpecialties implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        SpecialtyService specialtyService = serviceWarehouse.getSpecialtyService();
        try {
            List<Specialty> specialties = specialtyService.findAll();
            request.setAttribute(RequestParameters.SPECIALTIES, specialties);
            page = PathPage.EDIT_SPECIALTIES;
        }catch (ServiceException e){
            page = PathPage.HOME;
        }
        return page;
    }
}
