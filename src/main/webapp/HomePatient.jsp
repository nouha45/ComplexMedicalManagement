<%@page import="com.miola.complexeMedicale.dao.AppointementDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.miola.complexeMedicale.models.Doctor" %>
<%@page import="com.miola.complexeMedicale.models.RendezVous" %>
<%@page import="com.miola.complexeMedicale.dao.DoctorDaoImp" %>
<%@page import="com.miola.complexeMedicale.connection.DbCon" %>

<%
DoctorDaoImp doc= new DoctorDaoImp(DbCon.getConnection());
List<Doctor> doctors = doc.getAllDoctors();
Doctor doctor;
Object id_p=session.getAttribute("id");
int idd = (Integer)id_p;
AppointementDAO appoi = new AppointementDAO(DbCon.getConnection());
List<RendezVous> rv = appoi.getAllAppById(idd);
RendezVous appointement;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/homePatient.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
<title>Home</title>

</head>

<body>

<div class="header">
    <%@ include file="Navbarjsp.jsp" %>

</div>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

<div class="bd">
<div class="container">
   <div class="card">
     <div class="circle">
       <h2>Our specialists</h2>
     </div>
     <div class="content">
     <p>Go to our list of specialists and make an appointment </p>
     <a href="#specialities">Read More</a>
     </div>
   </div>
   <div class="card">
     <div class="circle">
       <h2>Your appointments</h2>
     </div>
     <div class="content">
     <p>Check your appointments on our platform, from here </p>
     <a href="#!" data-bs-toggle="modal" data-bs-target="#appoi-modal">Read More</a>
     </div>
   </div>
   <div class="card">
     <div class="circle">
       <h2>Profil</h2>
     </div>
     <div class="content">
     <p>Check your personal information here</p>
     <a href="#!" data-bs-toggle="modal" data-bs-target="#profile-modal">Read More</a>
     </div>
   </div>
</div>
</div>
<div class="specialitsContainer text-center my-5" id="specialities">

  <span>Services</span>
  <h2>Our specialities</h2>
  <p class="text-muted pt-2">Discover here our specialties,</br>
   a selection of the best doctors and surgeons</p>
   
   <div class="row py-5">
   <div class="col-md-3">
   
      <div class="ic">
      
      <a href="#" class="item">
       <i class="fa fa-heartbeat "></i>     </a>
      </div>
      <h4>Cardiology</h4>
      
       
  </div>
  <div class="col-md-3">
   
      <div class="ic">
      
      <a href="#" class="item">
       <i class="fa fa-tooth "></i>     </a>
      </div>
      <h4>Dental</h4>
      
       
  </div>
  <div class="col-md-3">
   
      <div class="ic">
      
      <a href="#cards" class="item">
       <i class="fa fa-stethoscope"></i>     </a>
      </div>
      <h4>Generalist</h4>
      
       
  </div>
  <div class="col-md-3">
   
      <div class="ic">
      
      <a href="#" class="item">
      <i class="fa fa-baby"></i>    </a>
      </div>
      <h4>Pediatrician</h4>
      
       
  </div>
  <div class="col-md-3">
   
      <div class="ic">
      
      <a href="#" class="item">
       <i class="fa fa-lungs"></i>    </a>
      </div>
      <h4>Pneumology</h4>
      
       
  </div>
  <div class="col-md-3">
   
      <div class="ic">
      
      <a href="#" class="item">
       <i class="fa fa-brain"></i>     </a>
      </div>
      <h4>Neurology</h4>
      
       
  </div>
  <div class="col-md-3">
   
      <div class="ic">
      
      <a href="#" class="item">
         <i class="fa fa-person-pregnant"></i>
   </a>
      </div>
      <h4>Gynecology</h4>
      
       
  </div>
  <div class="col-md-3">
   
      <div class="ic">
      
      <a href="#" class="item">
      <i class="fa fa-eye"></i>    </a>
      </div>
      <h4>Ophtalmology</h4>
      
       
  </div>
  </div>
</div>

<!-- GENERALISTE -->
<div class="cards" id="cards">
<div class="genContainer ">
 <%
 if(!doctors.isEmpty()){
	 System.out.println("ana hna");
	 for(Doctor d:doctors){
	 int id_d= d.getId();
	 System.out.println(id_d);
	 %>
		 <div class=" genContent">
	      <div class=" genCard">
	          <div class="genCard-content">
	          <div class="genImage">
	            <img alt="" src="img/doc.jpg">
	          </div>
	          
	          <div class="media-icons">
	          <i class="fab fa-facebook"></i>
	          <i class="fab fa-twitter"></i>
	          <i class="fab fa-google"></i>
	          </div>
	          <div class="name-prof">
	          <span class="name">Dr.<%= d.getNom() %><% out.println(" "+d.getPrenom()); %></span>
	          <span class="prof">Generalist doctor</span>
	          </div>
	          
	          <div class="rating">
	          <i class="fas fa-star"></i>
	          <i class="fas fa-star"></i>
	          <i class="fas fa-star"></i>
	          <i class="far fa-star"></i>
	          <i class="far fa-star"></i>
	          </div>
	          <div class="genBtn">
	          <button class="ab" ><a href="user-form.jsp?id=<%=d.getId()%>">Make an appointment</button>
	          </div>
	          </div>
	          </div>
	  </div>
	  

	  
	      
	  
	<% }}
 
 %>
 
  

       </div>
</div>



<div class="footer" id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
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
                                            <td><%= prenom %></td>

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




<!-- Modal Appointement -->
<div class="modal fade" id="appoi-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">My Appointements</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
    
      <div id="appoi-details">
  <%
 if(!rv.isEmpty()){
	 System.out.println("ana hna");
	 for(RendezVous ap:rv){
		 Connection con = DbCon.getConnection();
		 PreparedStatement ps=con.prepareStatement("select nom,prenom from doctor where id=?");
		int id_d= ap.getId_d();
		 ps.setInt(1, id_d);
		 ResultSet rs =ps.executeQuery();
		 if(rs.next()){
		 
	 %>
	 <div >
                                <span class="RvText" >Your appointement:</span><br>
                                <span ><%= ap.getDate() %>with Dr.<% out.print(rs.getString(1)+" "+rs.getString(2)); %></span><br>
 </div>
 <%
}
 }
 }
%>
                            </div>
                            	

<div class="modal-footer">
        <button type="button" class="btn btn-outline-primary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>







<script type="text/javascript" src="app.js" ></script>
 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<script type="text/javascript">
var status = document.getElementById("status").value;
if(status=="success"){
	swal("Congrats","Your appointement added succesfully","success");
}/*else{
	swal("Ops","Something went wrong","failed");
}*/
</script>

















</body>
</html>