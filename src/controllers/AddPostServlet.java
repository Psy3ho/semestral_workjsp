package controllers;

import cards.Post;
import dataAccesObject.AddPostDao;
import helpMetods.HelpMethods;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

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
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig
public class AddPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        String user_id = request.getParameter("user_id");


        Part filePart = request.getPart("file");
        String filename = HelpMethods.downloadPhoto(filePart);

        Post post = new Post(null,user_id,title,text,filename+"."+"png",null);

        AddPostDao addPostDao = new AddPostDao();
        String postPosted = addPostDao.addPost(post);
        if(postPosted.equals("SUCCESS"))
        {
            String redirectURL = "./index.jsp";
            response.sendRedirect(redirectURL);
        }
        else
        {
            request.setAttribute("errMessage", postPosted);
            request.getRequestDispatcher("./addPost.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
