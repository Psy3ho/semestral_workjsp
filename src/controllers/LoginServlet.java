package controllers;

import cards.User;
import dataAccesObject.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(null,email,password);

        LoginDao loginDao = new LoginDao();

        String userValidate = loginDao.authenticateUser(user);

        if(userValidate.equals("SUCCESS"))
        {
            HttpSession session =request.getSession();
            session.setAttribute("userLogged",email);
            request.getRequestDispatcher("./index.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("errMessage", userValidate);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
