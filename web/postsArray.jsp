<%@ page import="cards.Post" %>
<%@ page import="controllers.PostsController" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: egoeu
  Date: 8. 5. 2019
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    ArrayList<Post> postArrayList = null;

    if (request.getParameter("page") != null){
        int temp = Integer.valueOf(request.getParameter("page"));

        postArrayList =  new PostsController().getPosts(temp);
    } else if (request.getParameter("date1") != null) {

        String tempDate1 = request.getParameter("date1");
        String tempDate2 = request.getParameter("date2");
        postArrayList =  new PostsController().getPostsByDate(tempDate1, tempDate2);
    }
%>

<%
    for (int i =0; i< postArrayList.size();i++) {
%>
<div class="post-preview">
    <a href="post.jsp?postId=<%=postArrayList.get(i).getId()%>">
        <h2 class="post-title">
            <%=postArrayList.get(i).getTitle()%>
        </h2 >
    </a >
    <p class="post-meta" >
        <%
            String tempText  =postArrayList.get(i).getText();
            int a;
            if(tempText.length()<150){ a= tempText.length();}else { a = 150;};
            out.print(tempText.substring(0,a)+"...");
        %>
    </p >
    <p>
        <a  >Pridáné </a >
        <%=postArrayList.get(i).getDate()%>
    </p>
</div >
<hr >

<%
    }
%>