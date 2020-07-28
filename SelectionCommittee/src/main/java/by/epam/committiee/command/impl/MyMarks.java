package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.entity.Faculty;
import by.epam.committiee.entity.Result;
import by.epam.committiee.entity.Specialty;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.FacultyService;
import by.epam.committiee.service.ResultService;
import by.epam.committiee.service.SpecialtyService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class MyMarks implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        List<String> subjects = new ArrayList<>();
        subjects.add("Математика");
        subjects.add("Английский язык");
        subjects.add("Физика");
        subjects.add("Русский язык");
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        ResultService resultService = serviceWarehouse.getResultService();
        Result result;
        try {
            result = resultService.findById(Long.parseLong(request.getSession().getAttribute(RequestParameters.ID).toString()));
        } catch (ServiceException e) {
            result = new Result();
        }
        request.setAttribute(RequestParameters.RESULT, result);
        page = PathPage.MY_MARKS;
        return page;
    }
}
