package br.com.rodrigo.integrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.integrador.jdbc.ConnectionFactory;
import br.com.rodrigo.integrador.modelo.Sala;
import br.com.rodrigo.integrador.modelo.SalaOcupada;

public class SalaDAO {
	
	Connection connection;
	
	public SalaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Sala sala){
		String sql = "insert into sala (numeroSala, nome, capacidade) " +
				  "values (?,?,?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, sala.getNumeroSala());
			stmt.setString(2, sala.getNome());
			stmt.setInt(3, sala.getCapacidade());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Sala> lista(){
		try{
			List<Sala> salas = new ArrayList<Sala>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM sala");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Sala sala = new Sala();
				sala.setCodigoSala(rs.getInt("codigoSala"));
				sala.setNumeroSala(rs.getInt("numeroSala"));
				sala.setNome(rs.getString("nome"));
				sala.setCapacidade(rs.getInt("capacidade"));
				//adicionar objeto a lista
				salas.add(sala);
			}
			rs.close();
			stmt.close();

			return salas;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Sala sala){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from sala where codigoSala = ?");
			stmt.setInt(1, sala.getCodigoSala());
			stmt.execute();
			stmt.close();

		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Sala buscaPorId(int id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from sala");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getInt("codigoSala"))
				{
					//criando objeto tarefa
					Sala sala = new Sala();
					sala.setCodigoSala(rs.getInt("codigoSala"));
					sala.setNumeroSala(rs.getInt("numeroSala"));
					sala.setNome(rs.getString("nome"));
					sala.setCapacidade(rs.getInt("capacidade"));

					return sala;
				}
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}	
	}
	
	public void altera(Sala sala){
		String sql = "update sala set numeroSala=?, nome=?, capacidade=? where codigoSala=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, sala.getNumeroSala());
			stmt.setString(2, sala.getNome());
			stmt.setInt(3, sala.getCapacidade());
			stmt.setInt(4, sala.getCodigoSala());
			stmt.execute();
			stmt.close();

		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<SalaOcupada> listaReserva(){
		try{
			List<SalaOcupada> salasOcupadas = new ArrayList<SalaOcupada>();
			PreparedStatement stmt = this.connection.prepareStatement
					("SELECT s.codigoSalaOcupada, sl.nome AS nomeSala, t.nome AS nomeTurma, s.dia, "
							+ "CONVERT(char(10),s.dataInicial,103) AS dataInicial, "
							+ "CONVERT(char(10),s.dataTermino,103) AS dataTermino, "
							+ "CONVERT(char(5),s.horaInicio,108) AS horaInicio, "
							+ "CONVERT(char(5),s.horaTermino,108) AS horaTermino "
							+ "FROM salaOcupada AS s "
							+ "INNER JOIN sala AS sl "
							+ "ON s.codigoSala = sl.codigoSala "
							+ "INNER JOIN turma AS t "
							+ "ON s.codigoTurma = t.codigoTurma "
							+ "ORDER BY s.dataInicial, s.horaInicio");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				SalaOcupada salaOcupada = new SalaOcupada();
				salaOcupada.setCodigoSalaOcupada(rs.getInt("codigoSalaOcupada"));
				salaOcupada.setNomeSala(rs.getString("nomeSala"));
				salaOcupada.setNomeTurma(rs.getString("nomeTurma"));
				salaOcupada.setDia(rs.getString("dia"));
				salaOcupada.setDataInicial(rs.getString("dataInicial"));
				salaOcupada.setDataTermino(rs.getString("dataTermino"));
				salaOcupada.setHoraInicio(rs.getString("horaInicio"));
				salaOcupada.setHoraTermino(rs.getString("horaTermino"));
				//adicionar objeto a lista
				salasOcupadas.add(salaOcupada);
			}
			rs.close();
			stmt.close();
			
			return salasOcupadas;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
}
