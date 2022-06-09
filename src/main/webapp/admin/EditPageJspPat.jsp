  <%@ page import="com.miola.complexeMedicale.models.Patient" %> 
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <% Patient patient = (Patient) request.getAttribute("patientToEdit"); %> 
<!DOCTYPE html>
<html>
<head>

<title>Edit Patient</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/editForm.css" />
 <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
 
</head>
<body>
   <div class="container">
   <div class="title"> Edit Patients</div>
   <form action="UpdatePat" method="POST" >
   <div class="user-details">
  
  <input hidden name="id" value="<%= patient.getId() %>"/>  
   
   
   <div class="input-box">
   <span class="details">Username</span>
    <input type="text" class="form-control" required name="username" value="<%= patient.getUsername() %>" >
   </div>
   
   <div class="input-box">
   <span class="details">Nom</span>
     <input type="text" class="form-control" required name="nom" value="<%= patient.getNom() %>" >
   </div>
   
   <div class="input-box">
   <span class="details">Prenom</span>
      <input type="text" class="form-control" required  name="prenom" value="<%= patient.getPrenom() %>">
   </div>
   
   <div class="input-box">
   <span class="details">Email</span>
   <input type="email" class="form-control" required  name="email" value="<%= patient.getEmail() %>">
   </div>
   
   
   <div class="input-box">
   <span class="details">Telephone</span>
   <input type="text" class="form-control" required  name="tel" value="<%= patient.getTel() %>">
   </div>
   
   <div class="input-box">
   <span class="details">Mot de passe</span>
  <input type="password" class="form-control" required  name="password" value="<%= patient.getPassword() %>">
   </div>
   
   
   
     <div class="input-box">
     <button type="submit" class="btn btn-success">Save</button>
   <a href="patientsCrud.jsp"> <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button></a> 
     </div>
    </div>
   </form>
   </div>
</body>
</html>