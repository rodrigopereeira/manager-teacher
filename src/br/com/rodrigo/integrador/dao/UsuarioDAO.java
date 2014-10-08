package br.com.rodrigo.integrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.rodrigo.integrador.jdbc.ConnectionFactory;
import br.com.rodrigo.integrador.modelo.Usuario;

public class UsuarioDAO {
	
	Connection connection;
	
	public UsuarioDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean existeUsuario(Usuario usuario){
		
		boolean autenticado = false;
		
		String sql = "select * from usuarios where login=? and senha=?";
		
		try{
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		
		stmt.setString(1, usuario.getLogin());
		stmt.setString(2, usuario.getSenha());
		
		ResultSet rs = stmt.executeQuery();
		
		//verifica se existe retorno na consulta
		if (rs.next()) {  
			usuario.setNome(rs.getString(4));
			usuario.setCodGrupoUsuario(rs.getInt(5));
			usuario.setIdentificacao(rs.getInt(6));

			stmt.close();
			autenticado = true; 
		}
		
		return autenticado;
		
	}catch(SQLException e){
		throw new RuntimeException(e);
	}
}
}
