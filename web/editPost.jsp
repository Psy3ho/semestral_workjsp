<%@ page import="cards.User" %>
<%@ page import="controllers.UserController" %>
<%@ page import="cards.Post" %>
<%@ page import="controllers.PostController" %><%--
  Created by IntelliJ IDEA.
  User: egoeu
  Date: 5. 5. 2019
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Moj Blog</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/imagecss.css?v=12" rel="stylesheet" >


    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

    <script>
        function validate()
        {
            var title = document.form.title.value;
            var text = document.form.text.value;
            var file = document.form.file.value;

            if (title==null || title=="")
            {
                alert("Napíšte titulok článku.");
                return false;
            }
            else if (text==null || text=="")
            {
                alert("Napíšte aj obsah článku.");
                return false;
            } else if(file == null || file==""){
                alert("Vyberte obrázok pre článok.");
                return false;
            }
        }
    </script>

</head>
<body>

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
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">O nás</a>
                </li>
                <%
                    if(session.getAttribute("userLogged")!= null){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Zrušiť</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="LogoutServlet">Odhlásiť sa</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Header -->
<header class="masthead" style="background-image: url('img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="site-heading">
                    <h1>Úprava príspevku</h1>
                    <span class="subheading">
              <%
                  String id = request.getParameter("postId");
                  Post post = new PostController().getPost(id);
                  User user = new UserController().getUserEmail(String.valueOf(session.getAttribute("userLogged")));
                  out.print("Autor " +user.getName());

              %>
            </span>
                </div>
            </div>
        </div>
    </div>
</header>


<!-- Main Content -->
<form enctype="multipart/form-data" class="text-center border border-light p-5" name="form" action="EditPostServlet" method="post" onsubmit="return validate()">

    <!-- userId -->
    <input type="hidden" name="id" id="id" value="<%=post.getId()%>"/>

    <!-- Name -->
    <input type="text" name="title" id="title" class="form-control mb-4" placeholder="Názov článku" value=<%=post.getTitle()%>>


    <!-- Message -->
    <div class="form-group">
        <textarea class="form-control rounded-0" name="text" id="text" rows="10" placeholder="Text článku"><%=post.getText()%></textarea>
    </div>

    <!-- Send picture -->
    <div class="panel panel-default">
        <div class="panel-heading">
            Zmeniť titulný obrázok
        </div>
        <div class="panel-body">
            <div class="form-group">
                <input type="file" name="file" id="file" class="inputfile"/>
                <label for="file"><i class="fas fa-plus"></i></label>
            </div>
        </div>
    </div>

    <!-- Send button -->
    <button class="btn btn-info btn-block" type="submit">Upraviť príspevok</button>

</form>

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
