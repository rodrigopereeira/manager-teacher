package br.com.rodrigo.integrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.integrador.jdbc.ConnectionFactory;
import br.com.rodrigo.integrador.modelo.Especialidade;
import br.com.rodrigo.integrador.modelo.Estado;
import br.com.rodrigo.integrador.modelo.EstadoCivil;
import br.com.rodrigo.integrador.modelo.Sexo;

public class ComboDAO {
	
	Connection connection;
	
	public ComboDAO () {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public List<Sexo> listaSexo(){
		try{
			List<Sexo> sexos = new ArrayList<Sexo>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from sexo");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Sexo sexo = new Sexo();
				sexo.setCodigoSexo(rs.getInt("codigoSexo"));
				sexo.setDescricao(rs.getString("descricao"));
				//adicionar objeto a lista
				sexos.add(sexo);
			}
			rs.close();
			stmt.close();
			return sexos;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
		
	}
	
	public List<EstadoCivil> listaEstadoCivil(){
		try{
			List<EstadoCivil> estadosCivis = new ArrayList<EstadoCivil>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from estadoCivil");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				EstadoCivil estadoCivil = new EstadoCivil();
				estadoCivil.setCodigoEstadoCivil(rs.getInt("codigoEstadoCivil"));
				estadoCivil.setDescricao(rs.getString("descricao"));
				//adicionar objeto a lista
				estadosCivis.add(estadoCivil);
			}
			rs.close();
			stmt.close();
			return estadosCivis;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
		
	}
	
	public List<Estado> listaEstado(){
		try{
			List<Estado> estados = new ArrayList<Estado>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from estado");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Estado estado = new Estado();
				estado.setCodigoEstado(rs.getInt("codigoEstado"));
				estado.setSigla(rs.getString("sigla"));
				estado.setEstado(rs.getString("estado"));
				//adicionar objeto a lista
				estados.add(estado);
			}
			rs.close();
			stmt.close();
			return estados;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
		
	}
	
	public List<Especialidade> listaEspecialidade(){
		try{
			List<Especialidade> especialidades = new ArrayList<Especialidade>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from especialidade");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Especialidade especialidade = new Especialidade();
				especialidade.setCodigoEspecialidade(rs.getInt("codigoEspecialidade"));
				especialidade.setDescricao(rs.getString("descricao"));
				//adicionar objeto a lista
				especialidades.add(especialidade);
			}
			rs.close();
			stmt.close();
			return especialidades;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
		
	}

}
