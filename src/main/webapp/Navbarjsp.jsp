<%@page import="com.miola.complexeMedicale.Beans.LoginBean"%>
<%
Object id = session.getAttribute("id");
Object nom,prenom,email,tel,username;
nom=session.getAttribute("nom");
prenom=session.getAttribute("prenom");
tel=session.getAttribute("tel");
email=session.getAttribute("email");
username=session.getAttribute("username");
System.out.print(id);
if(id==null){
	response.sendRedirect("login.jsp");
	
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8"/>
 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
   <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css"
      integrity="sha256-x8PYmLKD83R9T/sYmJn1j3is/chhJdySyhet/JuHnfY="
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/1.4.0/tailwind.min.css"
      integrity="sha256-CAI/7ThhltsmP2L2zKBYa7FknB3ZwFbD0nqL8FCdxdc="
      crossorigin="anonymous"
    />
    <!-- CSS -->
     <link rel="stylesheet" href="css/complexeMedicale.css" />
     <link rel="stylesheet" href="WEB-INF/tailwind.min.css"/>
     <!-- Bootstrap -->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"/>
     <script src="https://kit.fontawesome.com/a62f3c1ab2.js" crossorigin="anonymous"></script>
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.1/css/fontawesome.min.css">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
     
     
     
</head>
<body>
<div class="header">
<div class="menu-bar">
<nav class="navbar navbar-expand-lg navbar-light ">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><image src="img/logo-.png"/></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <i class="fa fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link "  href="HomePatient.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#specialities">Our specialits</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#profile-modal">Profil</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="#conntact" tabindex="-1" aria-disabled="true">Contact</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="logout.jsp">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</div>
</div>

<!-- Modal -->
<div class="modal fade" id="profile-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">My profil</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div id="profile-details">
                                <table class="table">

                                    <tbody>
                                        <tr>
                                            <th scope="row"> First Name :</th>
                                            <td> <%= nom%></td>

                                        </tr>
                                        <tr>
                                            <th scope="row"> Last Name : </th>
                                            <td><%= prenom%></td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Username :</th>
                                            <td><%= username%></td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Email :</th>
                                            <td><%= email%></td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Phone :</th>
                                            <td><%= tel%></td>

                                        </tr>
                                    </tbody>
                                </table>
                            </div>


      <div class="modal-footer">
        <button type="button" class="btn btn-outline-primary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-outline-warning">Edit</button>
      </div>
    </div>
  </div>
</div>






</body>
