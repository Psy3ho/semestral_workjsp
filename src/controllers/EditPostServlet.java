package controllers;

import cards.Post;
import dataAccesObject.EditPostDao;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class EditPostServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "public";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String id = request.getParameter("id");
            String title = request.getParameter("title");
            String text = request.getParameter("text");

            String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIRECTORY;
            System.out.println("Upload path: " + uploadPath);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();
            String fileName;
            Post post;


            Part part;
            part =request.getPart("file");
            if(part.getContentType().contains("image")){
                fileName = part.getInputStream().toString();
                post = new Post(id, null,title,text,fileName+".png",null);
                part.write(uploadPath + File.separator + fileName+".png");
            } else {
                post = new Post(id, null,title,text,null,null);
            }
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

            response.getWriter().write("File upload OK");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
