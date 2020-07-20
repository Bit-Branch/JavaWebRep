package by.epam.committiee.command.impl;



import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.command.PathPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WrongRequest implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PathPage.ERROR;
    }
}