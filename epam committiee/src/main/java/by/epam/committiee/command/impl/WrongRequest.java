package by.epam.committiee.command.impl;



import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.constant.PathConsts;

import javax.servlet.http.HttpServletRequest;

public class WrongRequest implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return PathConsts.ERROR;
    }
}