package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;
import by.epam.committiee.command.RequestParameters;
import by.epam.committiee.entity.Result;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.AccountService;
import by.epam.committiee.service.ResultService;
import by.epam.committiee.service.warehouse.ServiceWarehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditMarks implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String certificateMark = request.getParameter("certificateMark");
        String markOne = request.getParameter("mark1");
        String markTwo = request.getParameter("mark2");
        String markThree = request.getParameter("mark3");
        String markFour = request.getParameter("mark4");
        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        ResultService resultService = serviceWarehouse.getResultService();
        Result result;
        try {
            result = resultService.findById(Long.valueOf(request.getSession().getAttribute(RequestParameters.ID).toString()));
            if (result == null){
                result = new Result();
            }
            result.setId(Long.parseLong(request.getSession().getAttribute(RequestParameters.ID).toString()));
            result.setCertificateMark(Integer.parseInt(certificateMark));
            result.setFirstExamMark(Integer.parseInt(markOne));
            result.setSecondExamMark(Integer.parseInt(markTwo));
            result.setThirdExamMark(Integer.parseInt(markThree));
            result.setFourthExamMark(Integer.parseInt(markFour));
            resultService.update(result);
        } catch (ServiceException ex){
            result = new Result();
            result.setId(Long.parseLong(request.getSession().getAttribute(RequestParameters.ID).toString()));
            result.setCertificateMark(Integer.parseInt(certificateMark));
            result.setFirstExamMark(Integer.parseInt(markOne));
            result.setSecondExamMark(Integer.parseInt(markTwo));
            result.setThirdExamMark(Integer.parseInt(markThree));
            result.setFourthExamMark(Integer.parseInt(markFour));
            try {
                resultService.create(result);
            } catch (ServiceException e) {
                request.setAttribute(RequestParameters.ERROR_MESSAGE, "cant update marks");
            }
        }
        return PathPage.MY_MARKS;
    }
}
