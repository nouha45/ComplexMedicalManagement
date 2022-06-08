
     <%@ page import="com.miola.complexeMedicale.models.Doctor" %> 
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <% Doctor doctor = (Doctor) request.getAttribute("doctorToEdit"); %> 
<!DOCTYPE html>
<html>
<head>

<title>Edit Doctor</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/editForm.css" />
 <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
 
</head>
<body>
   <div class="container">
   <div class="title"> Edit Doctors</div>
   <form action="UpdateDoc" method="POST" >
   <div class="user-details">
  
  <input hidden name="id" value="<%= doctor.getId() %>"/>  
   
   
   <div class="input-box">
   <span class="details">Username</span>
    <input type="text" class="form-control" required name="username" value="<%= doctor.getUsername() %>" >
   </div>
   
   <div class="input-box">
   <span class="details">Nom</span>
     <input type="text" class="form-control" required name="nom" value="<%= doctor.getNom() %>" >
   </div>
   
   <div class="input-box">
   <span class="details">Prenom</span>
      <input type="text" class="form-control" required  name="prenom" value="<%= doctor.getPrenom() %>">
   </div>
   
   <div class="input-box">
   <span class="details">Email</span>
   <input type="email" class="form-control" required  name="email" value="<%= doctor.getEmail() %>">
   </div>
   
   
   <div class="input-box">
   <span class="details">Telephone</span>
   <input type="text" class="form-control" required  name="tel" value="<%= doctor.getTel() %>">
   </div>
   
   <div class="input-box">
   <span class="details">Mot de passe</span>
  <input type="password" class="form-control" required  name="password" value="<%= doctor.getPassword() %>">
   </div>
   
   
   <div class="input-box">
   <span class="details">Spetialite</span>
   <input type="text" class="form-control" required  name="specialite" value="<%= doctor.getSpecialite() %>">
   </div>
     <div class="input-box">
     <button type="submit" class="btn btn-success">Save</button>
   <a href="#"> <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button></a> 
     </div>
    </div>
   </form>
   </div>
</body>
</html>