<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.miola.complexeMedicale.connection.DbCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet" href="css/user-form.css">
</head>
<body>
<div class="header">
    <%@ include file="Navbarjsp.jsp" %>

</div>

<div class="bd">
<div class="container">
<div class="title">Make an appointement</div>
<%
Connection con = DbCon.getConnection();
PreparedStatement ps=con.prepareStatement("select id,nom,prenom from doctor where id=?");
int idd = Integer.parseInt(request.getParameter("id"));
ps.setInt(1, idd);
ResultSet rs =ps.executeQuery();
Object id_p=session.getAttribute("id");
%>
<%
if(rs.next()){
	%>
	<form action="Appointement" method="post">
	<div class="doc-details">
	  <div class="input-box">
	    <span class="details">First name of the doctor</span>
	    <input type="text" name="nom" value="<%=rs.getString(2)%>">
	    <input type="hidden" name="id" value="<%=rs.getInt(1)%>">
	    <input type="hidden" name="id_p" value="<%=id_p%>">
	    
	    
	  
	  </div>
	  <div class="input-box">
	    <span class="details">Last name of the doctor</span>
	    <input type="text" name="prenom" value="<%=rs.getString(3)%>">
	    
	  
	  </div>
	  <div class="input-box">
	    <span class="details">Date of appointement</span>
	    <input type="date" name="date" required="required">
	    
	  
	  </div>
	  <div class="input-box">
	    <span class="details">Speciality</span>
	    <input type="text" name="speciality" value="Generalist" disabled="disabled">
	    
	  
	  </div>
	
	</div>
	<div class="button">
	<input type="submit" value="save">
	
	</div>
	

</form>
	<%
}
rs.close();
	%>





</div>

</div>





<div class="footer" id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
</div>

</body>
</html>