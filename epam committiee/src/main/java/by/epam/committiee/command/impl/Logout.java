package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;

import javax.servlet.http.HttpServletRequest;

public class Logout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String response= PathPage.HOME;
        request.getSession().invalidate();
        return response;
    }
}
