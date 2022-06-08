
  <%@ page import="com.miola.complexeMedicale.models.Doctor" %> 
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <% Doctor doctor = (Doctor) request.getAttribute("doctorToEdit"); %> 
  <html>
  <title>Edit page</title>
  <head>
  <link rel="stylesheet" href="editForm.css" />
  </head>
 
 <body>
 

<div class="modal fade" tabindex="-1" id="editDoctorModal" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Edit Doctors</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <div class="modal-body">
      <form action="UpdateDoc" method="POST" > 
      <div class="form-group">
      <input hidden name="id" value="<%= doctor.getId() %>"/>  
      </div>
       <div class="form-group">
       <label>UserName</label>
       <input type="text" class="form-control" required name="username" value="<%= doctor.getUsername() %>" >
       </div>
       <div class="form-group">
       <label>Nom</label>
       <input type="text" class="form-control" required name="nom" value="<%= doctor.getNom() %>" >
      </div>
       <div class="form-group">
       <label>Prenom</label>
       <input type="text" class="form-control" required  name="prenom" value="<%= doctor.getPrenom() %>">
       </div>
       <div class="form-group">
       <label>Email</label>
       <input type="email" class="form-control" required  name="email" value="<%= doctor.getEmail() %>">
       </div>
       <div class="form-group">
       <label>Telephone</label>
       <input type="text" class="form-control" required  name="tel" value="<%= doctor.getTel() %>">
       </div>
       <div class="form-group">
       <label>Mot de passe </label>
       <input type="password" class="form-control" required  name="password" value="<%= doctor.getPassword() %>">
       </div>
       <div class="form-group">
       <label>Specialite </label>
       <input type="text" class="form-control" required  name="specialite" value="<%= doctor.getSpecialite() %>">
       </div>
      
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button> 
        <button type="submit" class="btn btn-success">Save</button>
      </div>
   
    </div>
       </form>
  </div>
</div>
</body>
</html>

  
  <!-- edit modal end -->