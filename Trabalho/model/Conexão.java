package model;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class Conexão {
		
	    private static final String HOST = "da_java.mysql.dbaas.com.br";
	    private static final String BANCO = "da_java";
	    private static final String USUARIO = "da_java";
	    private static final String SENHA = "Tecnicas*2023@";

	    
	    public Connection getConexao() {
	    	
	        String url = "jdbc:mysql://" + HOST + "/" + BANCO + "?verifyServerCertificate=false&useSSL=false";
	        
	        try {
	            
	        	return DriverManager.getConnection(url, USUARIO, SENHA);
	        
	        } catch (SQLException ex) {
	            
	        	System.out.println("Conexão com o MySQL não realizada");
	            ex.printStackTrace();
	        
	        }
	        return null;
	    }
	}
