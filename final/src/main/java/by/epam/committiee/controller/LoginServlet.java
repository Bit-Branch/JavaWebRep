package by.epam.committiee.controller;

import by.epam.committiee.dao.AccountDao;
import by.epam.committiee.entity.Account;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

//    @EJB
//    private FacultyBean facultyBean = new FacultyBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        List<Faculty> allFaculty = facultyBean.getAll();
//
//        req.setAttribute("faculties", allFaculty);

        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        try {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if (!password.equals("") && !login.equals("")) {
                AccountDao accountDao = AccountDao.getInstance();
                if (accountDao.findBy(login,password) == null){
                    throw new Exception();
                }
            }
            req.getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

}
