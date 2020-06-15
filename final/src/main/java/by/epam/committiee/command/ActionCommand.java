package by.epam.committiee.command;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request);
}
