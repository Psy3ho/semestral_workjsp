package controllers;

import dataAccesObject.RemovePostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePostServlet")
public class DeletePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("post_idR");
        RemovePostDao removePostDao = new RemovePostDao();
        String deletedPost = removePostDao.removePost(id);
        if(deletedPost.equals("SUCCESS"))
        {
            String redirectURL = "./index.jsp";
            response.sendRedirect(redirectURL);
        }
        else
        {
            request.setAttribute("errMessage", deletedPost);
            request.getRequestDispatcher("./post.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
