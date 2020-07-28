package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUsers implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
