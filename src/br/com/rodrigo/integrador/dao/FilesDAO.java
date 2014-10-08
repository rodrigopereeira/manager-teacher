package br.com.rodrigo.integrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.integrador.jdbc.ConnectionFactory;
import br.com.rodrigo.integrador.modelo.Files;

public class FilesDAO {

	Connection connection;

	
	public FilesDAO()  {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public Files find(int id) {
		String sql = "select * from files where id = ?";
		Files file = new Files();
        try {
        	
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        	stmt.setInt(1, id);
        	ResultSet rs = stmt.executeQuery();
        	
        	while(rs.next()) {
        		file.setId(rs.getInt("id"));
    			file.setFilename(rs.getString("fileName"));
    			file.setNotes(rs.getString("notes"));
    			file.setType(rs.getString("type"));
    			file.setFile(rs.getBytes("arquivo"));
    	        
    			return file;
        	}

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
	

    public List<Files> listAll(int id) {
        String sql = "select id, filename, notes, type, arquivo from files where codigoTurma = ?";

        try{
            List<Files> files = new ArrayList<Files>();
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            	Files file = new Files();
            	file.setId(rs.getInt("id"));
    			file.setFilename(rs.getString("fileName"));
    			file.setNotes(rs.getString("notes"));
    			file.setType(rs.getString("type"));
    			file.setFile(rs.getBytes("arquivo"));
            	
               	files.add(file);
            }
            rs.close();
			stmt.close();
            
            return files;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public void save(final Files file) {
        String sql = "insert into files (filename, notes, type, arquivo, codigoTurma) values (?, ?, ?, ?, ?)";

        try {
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        	stmt.setString(1, file.getFilename());
        	stmt.setString(2, file.getNotes());
        	stmt.setString(3, file.getType());
        	stmt.setBytes(4, file.getFile());
        	stmt.setInt(5, file.getCodigoTurma());
        	
        	stmt.execute();
			stmt.close();
			
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id) {
        String sql = "delete from files where id = ?";

        try {
        	PreparedStatement stmt = this.connection.prepareStatement(sql);
        	stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
