package by.epam.committiee.command.impl;

import by.epam.committiee.command.ActionCommand;
import by.epam.committiee.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class SignUp implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request){
        return ""; //in process
    }
}