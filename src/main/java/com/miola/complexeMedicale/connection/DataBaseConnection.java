package com.miola.complexeMedicale.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private String jdbcURL="jdbc:mysql://localhost:3306/complexmedicale?useSSL=false";
    private String jdbcUsername="root";
    private String jdbcPassword="";
    private String jdbcDriver="com.mysql.jdbc.Driver";
    
    public Connection getConnection() {
  	  Connection connection=null;
  	  try {
  		  Class.forName("com.mysql.cj.jdbc.Driver");
  		  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
  		  
  	  }catch(SQLException e) {
  		  e.printStackTrace();
  	  }catch(ClassNotFoundException e) {
  		  e.printStackTrace();
  	  }
  	return connection;  
    }

}
