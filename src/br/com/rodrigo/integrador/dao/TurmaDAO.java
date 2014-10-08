package br.com.rodrigo.integrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.rodrigo.integrador.jdbc.ConnectionFactory;
import br.com.rodrigo.integrador.modelo.Matricula;
import br.com.rodrigo.integrador.modelo.Turma;

public class TurmaDAO {
	
Connection connection;
	
	public TurmaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Turma turma) throws ParseException{
		String sql = "insert into turma(codigoCurso, codigoProfessor, codigoSala, nome, vagas, horaInicio, "
				+ "horaTermino, dataInicio, dataTermino, notaAprovacao, frequenciaMinima, dia) " +
				  "values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Locale.setDefault (new Locale ("pt", "BR"));  
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");  
        Date data = df.parse (turma.getDataInicio());  
        DateFormat df2 = new SimpleDateFormat ("EEEE"); 
        
        String dataQueChegou = df2.format (data);
        
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, turma.getCodigoCurso());
			stmt.setInt(2, turma.getCodigoProfessor());
			stmt.setInt(3, turma.getCodigoSala());
			stmt.setString(4, turma.getNome());
			stmt.setInt(5, turma.getVagas());
			stmt.setString(6, turma.getHoraInicio());
			stmt.setString(7, turma.getHoraTermino());
			stmt.setString(8, turma.getDataInicio());
			stmt.setString(9, turma.getDataTermino());
			stmt.setInt(10, turma.getNotaAprovacao());
			stmt.setInt(11, turma.getFrequenciaMinima());
			stmt.setString(12, dataQueChegou);
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Turma> lista(){
		try{
			List<Turma> turmas = new ArrayList<Turma>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT t.codigoTurma, t.codigoCurso, c.nome as nomeCurso, t.codigoProfessor, p.nome as nomeProfessor, "
					+ "t.codigoSala, s.nome as nomeSala, t.nome, t.vagas, "
					+ "convert(char(5),t.horaInicio,108) as horaInicio, "
					+ "t.horaTermino, "
					+ "convert(char(10),t.dataInicio,103) as dataInicio,  "
					+ "convert(char(10),t.dataTermino,103) as dataTermino, t.notaAprovacao, "
					+ "t.frequenciaMinima, t.dia FROM turma AS t "
					+ "INNER JOIN curso AS c ON t.codigoCurso = c.codigoCurso "
					+ "INNER JOIN professor AS p ON t.codigoProfessor = p.codigoProfessor "
					+ "INNER JOIN sala AS S ON t.codigoSala = s.codigoSala");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Turma turma = new Turma();
				turma.setCodigoTurma(rs.getInt("codigoTurma"));
				turma.setCodigoCurso(rs.getInt("codigoCurso"));
				turma.setNomeCurso(rs.getString("nomeCurso"));
				turma.setCodigoProfessor(rs.getInt("codigoProfessor"));
				turma.setNomeProfessor(rs.getString("nomeProfessor"));
				turma.setCodigoSala(rs.getInt("codigoSala"));
				turma.setNomeSala(rs.getString("nomeSala"));
				turma.setNome(rs.getString("nome"));
				turma.setVagas(rs.getInt("vagas"));
				turma.setHoraInicio(rs.getString("horaInicio"));
				turma.setHoraTermino(rs.getString("horaTermino"));
				turma.setDataInicio(rs.getString("dataInicio"));
				turma.setDataTermino(rs.getString("dataTermino"));
				turma.setNotaAprovacao(rs.getInt("notaAprovacao"));
				turma.setFrequenciaMinima(rs.getInt("frequenciaMinima"));
				turma.setDia(rs.getString("dia"));
				//adicionar objeto a lista
				turmas.add(turma);
			}
			rs.close();
			stmt.close();

			return turmas;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Turma turma){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from turma where codigoTurma = ?");
			stmt.setInt(1, turma.getCodigoTurma());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Turma buscaPorId(int id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select codigoTurma, codigoCurso, "
					+ "codigoProfessor, codigoSala, nome, vagas, "
					+ "convert(char(5),horaInicio,108) as horaInicio, "
					+ "convert(char(5),horaTermino,108) as horaTermino, "
					+ "convert(char(10),dataInicio,103) as dataInicio, "
					+ "convert(char(10),dataTermino,103) as dataTermino, "
					+ "notaAprovacao, frequenciaMinima from turma");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getInt("codigoTurma"))
				{
					//criando objeto tarefa
					Turma turma = new Turma();
					turma.setCodigoTurma(rs.getInt("codigoTurma"));
					turma.setCodigoCurso(rs.getInt("codigoCurso"));
					turma.setCodigoProfessor(rs.getInt("codigoProfessor"));
					turma.setCodigoSala(rs.getInt("codigoSala"));
					turma.setNome(rs.getString("nome"));
					turma.setVagas(rs.getInt("vagas"));
					turma.setHoraInicio(rs.getString("horaInicio"));
					turma.setHoraTermino(rs.getString("horaTermino"));
					turma.setDataInicio(rs.getString("dataInicio"));
					turma.setDataTermino(rs.getString("dataTermino"));
					turma.setNotaAprovacao(rs.getInt("notaAprovacao"));
					turma.setFrequenciaMinima(rs.getInt("frequenciaMinima"));

					return turma;
				}
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}	
	}
	
	public void altera(Turma turma){
		String sql = "update turma set codigoCurso=?, codigoProfessor=?, codigoSala=?, nome=?"
				+ ", vagas=?, horaInicio=?, horaTermino=?, dataInicio=?, dataTermino=?"
				+ ", notaAprovacao=?, frequenciaMinima=? where codigoTurma=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, turma.getCodigoCurso());
			stmt.setInt(2, turma.getCodigoProfessor());
			stmt.setInt(3, turma.getCodigoSala());
			stmt.setString(4, turma.getNome());
			stmt.setInt(5, turma.getVagas());
			stmt.setString(6, turma.getHoraInicio());
			stmt.setString(7, turma.getHoraTermino());
			stmt.setString(8, turma.getDataInicio());
			stmt.setString(9, turma.getDataTermino());
			stmt.setInt(10, turma.getNotaAprovacao());
			stmt.setInt(11, turma.getFrequenciaMinima());
			stmt.setInt(12, turma.getCodigoTurma());
			stmt.execute();
			stmt.close();

		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public boolean verificaSalaDisponivel(Turma turma) throws ParseException {
		boolean resultado = true;
		
		String sql = "select sa.codigoSala, s.nome as nomeSala, t.nome as nomeTurma, sa.dia, "
				+ "sa.dataInicial, sa.dataTermino, sa.horaInicio, sa.horaTermino "
				+ "from salaOcupada as sa inner join sala as s on sa.codigoSala = s.codigoSala "
				+ "inner join turma as t on sa.codigoTurma = t.codigoTurma "
				+ "where sa.dia = ? "
				+ "and sa.horaInicio = ? "
				+ "and sa.horaTermino = ? "
				+ "and sa.dataTermino >= ? "
				+ "and sa.codigoSala = ? ";
		
		Locale.setDefault (new Locale ("pt", "BR"));  
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");  
        Date data = df.parse (turma.getDataInicio());  
        DateFormat df2 = new SimpleDateFormat ("EEEE"); 
        
        String dataQueChegou = df2.format (data);

		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, dataQueChegou);
			stmt.setString(2, turma.getHoraInicio());
			stmt.setString(3, turma.getHoraTermino());
			stmt.setString(4, turma.getDataInicio());
			stmt.setInt(5, turma.getCodigoSala());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {  

				resultado = true;
				stmt.close();
			} else {
				stmt.close();
				return resultado = false;
			}
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		return resultado;
	}
	
	public boolean verificaProfessorDisponivel(Turma turma) throws ParseException {
		boolean resultado = true;
		String sql = "select po.codigoProfessor, p.nome as nomeProfessor, t.nome as nomeTurma, "
				+ "po.dia, po.dataInicial, po.dataTermino, po.horaInicio, po.horaTermino "
				+ "from professorOcupado as po "
				+ "inner join professor as p on po.codigoProfessor = p.codigoProfessor "
				+ "inner join turma as t on po.codigoTurma = t.codigoTurma "
				+ "where po.dia = ? "
				+ "and po.horaInicio = ? "
				+ "and po.horaTermino = ? "
				+ "and po.dataTermino >= ? "
				+ "and po.codigoProfessor = ? ";
		
		Locale.setDefault (new Locale ("pt", "BR"));  
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");  
        Date data = df.parse (turma.getDataInicio());  
        DateFormat df2 = new SimpleDateFormat ("EEEE"); 
        
        String dataQueChegou = df2.format (data);
              
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			  
			stmt.setString(1, dataQueChegou);
			stmt.setString(2, turma.getHoraInicio());
			stmt.setString(3, turma.getHoraTermino());
			stmt.setString(4, turma.getDataInicio());
			stmt.setInt(5, turma.getCodigoProfessor());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {  

				resultado = true;
				stmt.close();
			} else {
				stmt.close();
				return resultado = false;
			}
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public int verificaSalaCapacidade(Turma turma) {
		//boolean resultado = false;
		int capacidadeTurma = 0;
		String sql = "select * from sala where codigoSala = ?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, turma.getCodigoSala());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				capacidadeTurma = rs.getInt("capacidade");
			}
			
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return capacidadeTurma;
	}
	
	public List<Turma> listaCursoDisponivel(){
		try{
			List<Turma> turmas = new ArrayList<Turma>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT t.codigoTurma, c.nome AS nomeCurso, t.codigoCurso, t.nome AS nomeTurma, "
					+ "t.vagasLivres, "
					+ "convert(char(5),t.horaInicio,108) AS horaInicio, "
					+ "convert(char(5),t.horaTermino,108) AS horaTermino, "
					+ "convert(char(10),t.dataInicio,103) AS dataInicio, "
					+ "convert(char(10),t.dataTermino,103) AS dataTermino, t.dia "
					+ "FROM turma AS t INNER JOIN curso AS C ON t.codigoCurso = c.codigoCurso "
					+ "WHERE vagasLivres > 0 order by c.nome ");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Turma turma = new Turma();
				turma.setCodigoTurma(rs.getInt("codigoTurma"));
				turma.setNomeCurso(rs.getString("nomeCurso"));
				turma.setCodigoCurso(rs.getInt("codigoCurso"));
				turma.setNome(rs.getString("nomeTurma"));
				turma.setVagas(rs.getInt("vagasLivres"));
				turma.setHoraInicio(rs.getString("horaInicio"));
				turma.setHoraTermino(rs.getString("horaTermino"));
				turma.setDataInicio(rs.getString("dataInicio"));
				turma.setDataTermino(rs.getString("dataTermino"));
				turma.setDia(rs.getString("dia"));
				//adicionar objeto a lista
				turmas.add(turma);
			}
			rs.close();
			stmt.close();

			return turmas;
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void matricula(Matricula matricula){
		String sql = "insert into matriculaAluno values (?,?,?,?)";
		
		Date data = new Date();  
		SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");  
		SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm"); 
		
		String horaQueChegou = formatadorHora.format (data);
        String dataQueChegou = formatadorData.format (data);
        
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, matricula.getCodigoAluno());
			stmt.setInt(2, matricula.getCodigoTurma());
			stmt.setString(3, dataQueChegou);
			stmt.setString(4, horaQueChegou);
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}

	public List<Turma> listaAlunos(Turma turmaID){
		
		String sql = "select tu.nome, t.codigoAluno, a.nome AS aluno, t.vagasDisponiveis, s.descricao "
			+ "from turmaMatricula AS t "
			+ "INNER JOIN turma AS tu "
			+ "ON t.codigoTurma = tu.codigoTurma "
			+ "INNER JOIN aluno AS a "
			+ "ON t.codigoAluno = a.codigoAluno "
			+ "INNER JOIN status AS s "
			+ "ON t.codigoStatus = s.codigoStatus "
			+ "WHERE t.codigoTurma = ?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, turmaID.getCodigoTurma());
			
			List<Turma> turmas = new ArrayList<Turma>();

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Turma turma = new Turma();
				turma.setNome(rs.getString("nome"));
				turma.setCodigoAluno(rs.getInt("codigoAluno"));
				turma.setNomeAluno(rs.getString("aluno"));
				turma.setVagas(rs.getInt("vagasDisponiveis"));
				turma.setDescricao(rs.getString("descricao"));
				//adicionar objeto a lista
				turmas.add(turma);
			}
			rs.close();
			stmt.close();

			return turmas;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
}
