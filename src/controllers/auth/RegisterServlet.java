package controllers.auth;

import cards.User;
import dataAccesObject.RegisterDao;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));

        User user = new User(null,name ,email,generatedSecuredPasswordHash);

        RegisterDao registerDao = new RegisterDao();
        String userRegistered = registerDao.registerUser(user);


        if(userRegistered.equals("SUCCESS"))
        {
            String redirectURL = "./index.jsp";
            response.sendRedirect(redirectURL);
        }
        else
        {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("./registration.jsp").forward(request, response);
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}