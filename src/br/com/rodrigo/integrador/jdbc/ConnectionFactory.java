package br.com.rodrigo.integrador.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {

	public Connection getConnection(){
		try {  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        return DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;"
	        		+ "databaseName=Mantea",
	        		"sa",
	        		"naosei");
	       
	    } catch (SQLException e) {  
	        throw new RuntimeException(e);  
	    }  
	    catch(ClassNotFoundException e){  
	        throw new RuntimeException(e);  
	    } 
		//"jdbc:mysql://localhost/academico", "root", "xi95gfg8"
	 }
	
	
	 
}