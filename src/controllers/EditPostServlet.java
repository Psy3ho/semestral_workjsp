package controllers;

import cards.Post;
import dataAccesObject.AddPostDao;
import dataAccesObject.EditPostDao;
import helpMetods.HelpMethods;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
public class EditPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        Part filePart = request.getPart("file");

        String filename = HelpMethods.downloadPhoto(filePart);
        Post post = new Post(id, null,title,text,filename+"."+"png",null);


        EditPostDao editPostDao = new EditPostDao();
        String postEdit = editPostDao.addPost(post);
        if(postEdit.equals("SUCCESS"))
        {
            String redirectURL = "./post.jsp?postId="+id;
            response.sendRedirect(redirectURL);
        }
        else
        {
            request.setAttribute("errMessage", postEdit);
            request.getRequestDispatcher("./editPost.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
