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
    int temp = Integer.valueOf(request.getParameter("page"));
    ArrayList<Post> postArrayList =  new PostsController().getPosts(temp);
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
        <%=postArrayList.get(i).getText().substring(0,150)+"..."%>
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