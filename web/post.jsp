<%@ page import="controllers.PostController" %>
<%@ page import="cards.Post" %>
<%@ page import="controllers.UserController" %>
<%@ page import="cards.User" %><%--
  Created by IntelliJ IDEA.
  User: egoeu
  Date: 5. 5. 2019
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

</head>

<body>
<%

    String id = request.getParameter("postId");
    Post post = new PostController().getPost(id);
    User user = new UserController().getUser(post.getUserId());
    User loggedUser =null;
    if(session.getAttribute("userLogged")!=null) {
        loggedUser = new UserController().getUserEmail(String.valueOf(session.getAttribute("userLogged")));
    }
%>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Domov</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <%
                    if(session.getAttribute("userLogged")!= null){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="datePosts.jsp">Hľadaj príspevky</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="LogoutServlet">Pridaj príspevok</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="LogoutServlet">Odhlásiť sa</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="datePosts.jsp">Hľadaj príspevky</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Prihlásiť sa</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="registration.jsp">Nemám účet</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Header -->
<header class="masthead" style="background-image: url('<%=request.getContextPath()%>/public/<%=post.getImage()%>')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="post-heading">
                    <h1><%=post.getTitle()%></h1>
                    <span class="meta">Pridané užívateľom
              <a href="#"><%=user.getName()%></a>
              <%=post.getDate()%></span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Post Content -->
<article>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <%=post.getText()%>
            </div>
        </div>
        <%
            if(session.getAttribute("userLogged")!=null) {
                if(post.getUserId().equals(loggedUser.getId())) {
        %>

        <form class="text-center border border-light p-5" name="form" action="DeletePostServlet" method="post">

            <!-- Edit button -->
            <div>
                <a  class="btn btn-info btn-block" href="editPost.jsp?postId=<%=post.getId()%>">
                    Upraviť príspevok
                </a>
            </div>

            <!-- userId -->
            <input type="hidden" name="post_idR" id="post_idR" value="<%=post.getId()%>"/>

            <div>
                <!-- Send button -->
                <button  class="btn btn-danger btn-block" type="submit">Vymazať príspevok</button>
            </div>

        </form>
        <%
                }
            }
        %>
    </div>
</article>

<hr>


<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <ul class="list-inline text-center">
                    <li class="list-inline-item">
                        <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
                        </a>
                    </li>
                </ul>
                <p class="copyright text-muted">Copyright &copy; PSY3HO Website 2019</p>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/clean-blog.min.js"></script>

</body>
</html>
