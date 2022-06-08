<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Login</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<div class="container">
  <div class="forms-container">
  
       <!-- Sign In -->
  
     <div class="signin-signup">
        <form action="LoginServlet" method="post" class="sign-in-form">
         <h2 class="title">Sign In</h2>
         <div class="input-field">
          <i class="fas fa-user"></i>
          <input type="text" placeholder="Username" name="user" required="required"/>
         </div>
         <div class="input-field">
          <i class="fas fa-lock"></i>
          <input type="password" placeholder="Password" required="required" name="pass"/>
         </div>
        <div class="nav-list">
                    <label>
                    <select name="type" id="select" >
                        <option value="Medecin">Doctor</option>
                        <option value="Patient">Patient</option>
                        <option value="Admin">Admin</option>
                    </select>
                    </label>
                </div>
                
<!-- 
<div class="radiobtn">
  <label class="form-control">
    <input type="radio" name="radio" checked >
    Docteur
  </label>
  <label class="form-control">
    <input type="radio" name="radio" >
    Patient
  </label>
  <label class="form-control">
    <input type="radio" name="radio" >
    Admin
  </label>
</div>  -->

           <input type="submit" class="btn solid"  value="Login"/>
         
           <p class="social-text">Or Sign in with social platforms</p>
           <div class="social-media">
           <a href="#" class="social-icon">
           <i class="fab fa-facebook-f"></i>
           </a> 
           <a href="#" class="social-icon">
           <i class="fab fa-twitter"></i>
           </a>  
           <a href="#" class="social-icon">
           <i class="fab fa-google"></i>
           </a>  
           <a href="#" class="social-icon">
           <i class="fab fa-linkedin"></i>
           </a>         
              </div>
        </form>
     </div>
     <!-- Sign Up -->
  <div class="signup-signup">
        <form action="#" class="sign-up-form">
         <h2 class="title">Sign Up</h2>
         <div class="input-field">
          <i class="fas fa-user"></i>
          <input type="text" placeholder="Username" />
         </div>
         <div class="input-field">
          <i class="fas fa-envelope"></i>
          <input type="email" placeholder="Email" />
         </div>
         <div class="input-field">
          <i class="fas fa-lock"></i>
          <input type="password" placeholder="Password" />
         </div>
         <!--  
         <div class="radiobtn">
  <label class="form-control">
    <input type="radio" name="radio" checked >
    Docteur
  </label>
  <label class="form-control">
    <input type="radio" name="radio" >
    Patient
  </label>
</div> -->
           <input type="submit" class="btn solid"  value="Sign up"/>
         
           <p class="social-text">Or Sign up with social platforms</p>
           <div class="social-media">
           <a href="#" class="social-icon">
           <i class="fab fa-facebook-f"></i>
           </a> 
           <a href="#" class="social-icon">
           <i class="fab fa-twitter"></i>
           </a>  
           <a href="#" class="social-icon">
           <i class="fab fa-google"></i>
           </a>  
           <a href="#" class="social-icon">
           <i class="fab fa-linkedin"></i>
           </a>         
              </div>
              
        </form>
     </div>
  </div>
    <div class="panels-container">
       <div class="panel left-panel">
        <div class="content">
        <h3>New here?</h3>
        <p> Welcome to the app of miola students,</br> 
        this application is developed in the context of the JEE project,</br> 
         by the students Zaglami fatima zahra & Elfahsi nouhaila.</p>
         <a href="inscription.jsp">
         <button class="btn transparent" id="sign-up-button">Sign Up</button></a>
        </div>
        <img src="img/log.svg" alt="" class="image" />
      </div>
    
   <!--    <div class="panel right-panel">
        <div class="content">
        <h3>One Of Us</h3>
        <p> Welcome to the app of miola students, 
        this application is developed in the context of the JEE project,
         by the students Zaglami fatima zahra & Elfahsi nouhaila.</p>
         
         <button class="btn transparent" id="sign-in-button">Sign In</button>
        </div>
        <img src="img/register.svg" alt="" class="image" />
      </div>
     --> 
    </div>
   
  

</div>
<% String m = (String)request.getAttribute ("resultat") ; if(m != null){%>
        <div class = "erreurMsg">
	        <b style =" color: red ;  ">
	        <%=m%>
	         </b>
   		</div>
   		<% }%>
      </div>  
      
      
<script type="text/javascript" src="app.js" ></script>
 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<script type="text/javascript">
var status = document.getElementById("status").value;
if(status=="failed"){
	swal("Sorry","Username or password wrong","failed");
}
</script>

</body>
</html>