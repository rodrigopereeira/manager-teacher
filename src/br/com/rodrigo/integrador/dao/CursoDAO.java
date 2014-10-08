package br.com.rodrigo.integrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.integrador.jdbc.ConnectionFactory;
import br.com.rodrigo.integrador.modelo.Curso;

public class CursoDAO {
	
Connection connection;
	
	public CursoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Curso curso){
		String sql = "insert into curso (nome, descricao, codigoEspecialidade1, codigoEspecialidade2, "
				+ "codigoEspecialidade3) " +
				  "values (?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, curso.getNome());
			stmt.setString(2, curso.getDescricao());
			stmt.setInt(3, curso.getCodigoEspecialidade1());
			stmt.setInt(4, curso.getCodigoEspecialidade2());
			stmt.setInt(5, curso.getCodigoEspecialidade3());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Curso> lista(){
		try{
			List<Curso> cursos = new ArrayList<Curso>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT c.codigoCurso, c.nome, c.descricao, c.codigoEspecialidade1, (es.descricao) "
					+ "AS especialidade1, c.codigoEspecialidade2, (esp.descricao) "
					+ "AS especialidade2, c.codigoEspecialidade3, (espe.descricao) "
					+ "AS especialidade3 FROM curso AS c "
					+ "INNER JOIN especialidade "
					+ "AS es ON c.codigoEspecialidade1 = es.codigoEspecialidade "
					+ "INNER JOIN especialidade "
					+ "AS esp ON c.codigoEspecialidade2 = esp.codigoEspecialidade "
					+ "INNER JOIN especialidade "
					+ "AS espe on c.codigoEspecialidade3 = espe.codigoEspecialidade");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Curso curso = new Curso();
				curso.setCodigoCurso(rs.getInt("codigoCurso"));
				curso.setNome(rs.getString("nome"));
				curso.setDescricao(rs.getString("descricao"));
				curso.setCodigoEspecialidade1(rs.getInt("codigoEspecialidade1"));
				curso.setEspecialidade1(rs.getString("especialidade1"));
				curso.setCodigoEspecialidade2(rs.getInt("codigoEspecialidade2"));
				curso.setEspecialidade2(rs.getString("especialidade2"));
				curso.setCodigoEspecialidade3(rs.getInt("codigoEspecialidade3"));
				curso.setEspecialidade3(rs.getString("especialidade3"));
				//adicionar objeto a lista
				cursos.add(curso);
			}
			rs.close();
			stmt.close();

			return cursos;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Curso curso){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from curso where codigoCurso = ?");
			stmt.setInt(1, curso.getCodigoCurso());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Curso buscaPorId(int id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from curso");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getInt("codigoCurso"))
				{
					//criando objeto tarefa
					Curso curso = new Curso();
					curso.setCodigoCurso(rs.getInt("codigoCurso"));
					curso.setNome(rs.getString("nome"));
					curso.setDescricao(rs.getString("descricao"));
					curso.setCodigoEspecialidade1(rs.getInt("codigoEspecialidade1"));
					curso.setCodigoEspecialidade2(rs.getInt("codigoEspecialidade2"));
					curso.setCodigoEspecialidade3(rs.getInt("codigoEspecialidade3"));

					return curso;
				}
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}	
	}
	
	public void altera(Curso curso){
		String sql = "update curso set nome=?, descricao=?, codigoEspecialidade1=?, "
				+ "codigoEspecialidade2=?, codigoEspecialidade3=? where codigoCurso=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, curso.getNome());
			stmt.setString(2, curso.getDescricao());
			stmt.setInt(3, curso.getCodigoEspecialidade1());
			stmt.setInt(4, curso.getCodigoEspecialidade2());
			stmt.setInt(5, curso.getCodigoEspecialidade3());
			stmt.setInt(6, curso.getCodigoCurso());
			stmt.execute();
			stmt.close();

		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
