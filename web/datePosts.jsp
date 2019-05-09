<%@ page import="cards.Post" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controllers.PostsController" %>
<%@ page import="helpMetods.HelpMethods" %>
<%@ page import="controllers.UserController" %>
<%@ page import="cards.User" %>
<%--
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

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

    <!--  jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

    <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->

    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

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
                <%
                    if(session.getAttribute("userLogged")!= null){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="addPost.jsp">Pridaj príspevok</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="LogoutServlet">Odhlásiť sa</a>
                </li>
                <%
                } else {
                %>
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
<header class="masthead" style="background-image: url('img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="site-heading">
                    <h1>Môj blog</h1>
                    <span class="subheading">
              <%
                  if(session.getAttribute("userLogged")!= null){
                      User user = new UserController().getUserEmail(String.valueOf(session.getAttribute("userLogged")));
                      out.print("Vitaj " +user.getName());
                  } else {
              %> Vitaj na mojom semestrálnom blogu<%
                        }
                    %>
            </span>
                </div>
            </div>
        </div>
    </div>
</header>




<!-- Main Content -->
<div class="container">

        <div class="col-lg-8 col-md-10 mx-auto" >
            <div class="row">
                <div class="bootstrap-iso">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col">

                                <!-- Form code begins -->
                                <form method="post" class="form-inline">
                                    <div class="form-group mr-4"> <!-- Date input -->
                                        <input class="floated form-control" style="float:left" id="date1" name="date1" placeholder="MM/DD/YYY" type="text"/>
                                    </div>
                                    <div class="form-group mr-4"> <!-- Date input -->
                                        <input class="form-control" id="date2" name="date2" placeholder="MM/DD/YYY" type="text"/>
                                    </div>
                                    <div class="form-group"> <!-- Submit button -->
                                        <button type="button" class="btn btn-sm btn-primary " id="dates" >Hľadaj</button>
                                    </div>
                                </form>
                                <!-- Form code ends -->

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="postsContainer">
            </div>
       </div>

</div>

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

<!-- Custom scripts for this template -->
<script src="js/clean-blog.min.js"></script>
<script src="js/ajax-pagination.js"></script>
<script src="js/show-date-posts.js"></script>

</body>
</html>
