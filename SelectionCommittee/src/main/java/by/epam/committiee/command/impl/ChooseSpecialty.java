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
import javax.swing.*;
import java.util.List;

public class ChooseSpecialty implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        SpecialtyService specialtyService = serviceWarehouse.getSpecialtyService();
        try {
            Specialty specialty = specialtyService.findById(Long.parseLong(request.getSession().getAttribute(RequestParameters.ID).toString()));
            request.setAttribute(RequestParameters.SPECIALTY, specialty);
            page = PathPage.SPECIALTY;
        }catch (ServiceException e){
            page = PathPage.HOME;
        }
        return page;
    }
}
