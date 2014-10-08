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
import br.com.rodrigo.integrador.modelo.Notas;
import br.com.rodrigo.integrador.modelo.Presenca;
import br.com.rodrigo.integrador.modelo.Professor;
import br.com.rodrigo.integrador.modelo.ProfessorOcupado;
import br.com.rodrigo.integrador.modelo.Turma;

public class ProfessorDAO {
	
	Connection connection;
	
	public ProfessorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Professor professor){
		String sql = "insert into professor (nome, dataNascimento, codigoSexo, "
				+ "codigoEstadoCivil, codigoEspecialidade, endereco, numero, bairro, "
				+ "codigoEstado, celular, telefone, email, cpf, rg, senha) " +
					"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getDataNascimento());
			stmt.setInt(3, professor.getCodigoSexo());
			stmt.setInt(4, professor.getCodigoEstadoCivil());
			stmt.setInt(5, professor.getCodigoEspecialidade());
			stmt.setString(6, professor.getEndereco());
			stmt.setString(7, professor.getNumero());
			stmt.setString(8, professor.getBairro());
			stmt.setInt(9, professor.getCodigoEstado());
			stmt.setString(10, professor.getCelular());
			stmt.setString(11, professor.getTelefone());
			stmt.setString(12, professor.getEmail());
			stmt.setString(13, professor.getCpf());
			stmt.setString(14, professor.getRg());
			stmt.setString(15, professor.getSenha());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Professor> lista(){
		try{
			List<Professor> professores = new ArrayList<Professor>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from professor");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Professor professor = new Professor();
				professor.setCodigoProfessor(rs.getInt("codigoProfessor"));
				professor.setNome(rs.getString("nome"));
				professor.setDataNascimento(rs.getString("dataNascimento"));
				professor.setCodigoSexo(rs.getInt("codigoSexo"));
				professor.setCodigoEstadoCivil(rs.getInt("codigoEstadoCivil"));
				professor.setCodigoEspecialidade(rs.getInt("codigoEspecialidade"));
				professor.setEndereco(rs.getString("endereco"));
				professor.setNumero(rs.getString("numero"));
				professor.setBairro(rs.getString("bairro"));
				professor.setCodigoEstado(rs.getInt("codigoEstado"));
				professor.setCelular(rs.getString("celular"));
				professor.setTelefone(rs.getString("telefone"));
				professor.setEmail(rs.getString("email"));
				professor.setCpf(rs.getString("cpf"));
				professor.setRg(rs.getString("rg"));
				professor.setSenha(rs.getString("senha"));
				//adicionar objeto a lista
				professores.add(professor);
			}
			rs.close();
			stmt.close();

			return professores;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Professor professor){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from professor where codigoProfessor = ?");
			
			stmt.setInt(1, professor.getCodigoProfessor());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Professor buscaPorId(int id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select codigoProfessor, "
					+ "nome, "
					+ "CONVERT(char(10),dataNascimento,103) AS dataNascimento, "
					+ "codigoSexo, codigoEstadoCivil, codigoEspecialidade, endereco, numero, "
					+ "bairro, codigoEstado, celular, telefone, email, cpf, rg, senha from professor");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getInt("codigoProfessor"))
				{
					//criando objeto tarefa
					Professor professor = new Professor();
					professor.setCodigoProfessor(rs.getInt("codigoProfessor"));
					professor.setNome(rs.getString("nome"));
					professor.setDataNascimento(rs.getString("dataNascimento"));
					professor.setCodigoSexo(rs.getInt("codigoSexo"));
					professor.setCodigoEstadoCivil(rs.getInt("codigoEstadoCivil"));
					professor.setCodigoEspecialidade(rs.getInt("codigoEspecialidade"));
					professor.setEndereco(rs.getString("endereco"));
					professor.setNumero(rs.getString("numero"));
					professor.setBairro(rs.getString("bairro"));
					professor.setCodigoEstado(rs.getInt("codigoEstado"));
					professor.setCelular(rs.getString("celular"));
					professor.setTelefone(rs.getString("telefone"));
					professor.setEmail(rs.getString("email"));
					professor.setCpf(rs.getString("cpf"));
					professor.setRg(rs.getString("rg"));
					professor.setSenha(rs.getString("senha"));

					return professor;
				}
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}	
	}
	
	public void altera(Professor professor){
		String sql = "update professor set nome=?, dataNascimento=?, codigoSexo=?, "
				+ "codigoEstadoCivil=?, codigoEspecialidade=?, "
				+ "endereco=?, numero=?, bairro=?, codigoEstado=?, celular=?, "
				+ "telefone=?, email=?, cpf=?, rg=?, senha=? where codigoProfessor=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getDataNascimento());
			stmt.setInt(3, professor.getCodigoSexo());
			stmt.setInt(4, professor.getCodigoEstadoCivil());
			stmt.setInt(5, professor.getCodigoEspecialidade());
			stmt.setString(6, professor.getEndereco());
			stmt.setString(7, professor.getNumero());
			stmt.setString(8, professor.getBairro());
			stmt.setInt(9, professor.getCodigoEstado());
			stmt.setString(10, professor.getCelular());
			stmt.setString(11, professor.getTelefone());
			stmt.setString(12, professor.getEmail());
			stmt.setString(13, professor.getCpf());
			stmt.setString(14, professor.getRg());
			stmt.setString(15, professor.getSenha());
			stmt.setInt(16, professor.getCodigoProfessor());
			stmt.execute();
			stmt.close();

		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<ProfessorOcupado> listaReserva(){
		try{
			List<ProfessorOcupado> professoresOcupados = new ArrayList<ProfessorOcupado>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT p.codigoProfessorOcupado, pr.nome AS nomeProfessor, t.nome AS nomeTurma, p.dia, "
					+ "CONVERT(char(10),p.dataInicial,103) AS dataInicial, "
					+ "CONVERT(char(10),p.dataTermino,103) AS dataTermino, "
					+ "CONVERT(char(5),p.horaInicio,108) AS horaInicio, "
					+ "CONVERT(char(5),p.horaTermino,108) AS horaTermino "
					+ "FROM professorOcupado AS p "
					+ "INNER JOIN professor AS pr "
					+ "ON p.codigoProfessor = pr.codigoProfessor "
					+ "INNER JOIN turma AS t "
					+ "ON p.codigoTurma = t.codigoTurma "
					+ "ORDER BY p.dataInicial, p.horaInicio");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				ProfessorOcupado professorOcupado = new ProfessorOcupado();
				professorOcupado.setCodigoProfessorOcupado(rs.getInt("codigoProfessorOcupado"));
				professorOcupado.setNomeProfessor(rs.getString("nomeProfessor"));
				professorOcupado.setNomeTurma(rs.getString("nomeTurma"));
				professorOcupado.setDia(rs.getString("dia"));
				professorOcupado.setDataInicial(rs.getString("dataInicial"));
				professorOcupado.setDataTermino(rs.getString("dataTermino"));
				professorOcupado.setHoraInicio(rs.getString("horaInicio"));
				professorOcupado.setHoraTermino(rs.getString("horaTermino"));
				//adicionar objeto a lista
				professoresOcupados.add(professorOcupado);
			}
			rs.close();
			stmt.close();

			return professoresOcupados;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public List<Turma> listaTurmasProfessor(int professorID) throws ParseException{
		
		String sql = "select codigoTurma, codigoProfessor, nome "
				+ "from turma "
				+ "where codigoProfessor = ? "
				+ "and dia = ?";
		
		Locale.setDefault (new Locale ("pt", "BR"));  
		
        DateFormat df = new SimpleDateFormat ("EEEE"); 
        Date date = new Date();
        String dataString = df.format(date);
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, professorID);
			stmt.setString(2, dataString);
			
			List<Turma> turmas = new ArrayList<Turma>();

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Turma turma = new Turma();
				turma.setCodigoTurma(rs.getInt("codigoTurma"));
				turma.setCodigoProfessor(rs.getInt("codigoProfessor"));
				turma.setNome(rs.getString("nome"));
				
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
	
	public List<Presenca> chamadaTurma(int turmaID){
		
		String sql = "select p.codigoTurma, t.nome as nomeTurma, p.codigoAluno, a.nome as nomeAluno, "
				+ "CONVERT(char(10),p.data,103) AS data, p.dia, "
				+ "CONVERT(char(5),p.hora,108) AS hora, p.presente "
				+ "from presencaAluno as p "
				+ "INNER JOIN turma as t "
				+ "ON p.codigoTurma = t.codigoTurma "
				+ "INNER JOIN aluno as a "
				+ "ON p.codigoAluno = a.codigoAluno "
				+ "where p.codigoTurma = ? "
				+ "and p.data = ?";
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy"); 
		String dataString = df.format(date);
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, turmaID);
			stmt.setString(2, dataString);
			
			List<Presenca> presencas = new ArrayList<Presenca>();

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Presenca presenca = new Presenca();
				presenca.setCodigoTurma(rs.getInt("codigoTurma"));
				presenca.setNomeTurma(rs.getString("nomeTurma"));
				presenca.setCodigoAluno(rs.getInt("codigoAluno"));
				presenca.setNomeAluno(rs.getString("nomeAluno"));
				presenca.setData(rs.getString("data"));
				presenca.setDia(rs.getString("dia"));
				presenca.setHora(rs.getString("hora"));
				presenca.setPresenca(rs.getString("presente"));
				
				//adicionar objeto a lista
				presencas.add(presenca);
			}
			rs.close();
			stmt.close();

			return presencas;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void finalizaChamada(List<Presenca> listaPresencasController){
		String sql = "update presencaAluno set presente =? where codigoAluno=? and data=? and codigoTurma=?";
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy"); 
		String dataString = df.format(date);
		
		
		for (int i=0; i < listaPresencasController.size();i++) {
			try{
				PreparedStatement stmt = this.connection.prepareStatement(sql);;
				String status = new String();
				
				String comparar = listaPresencasController.get(i).getPresenca();
				
				if ( comparar == null) {
					status = "Falta";
				} else {
					status = "Presente";
				}

				stmt.setString(1, status);
				stmt.setInt(2, listaPresencasController.get(i).getCodigoAluno());
				stmt.setString(3, dataString);
				stmt.setInt(4, listaPresencasController.get(i).getCodigoTurma());
				
				
				stmt.execute();
				stmt.close();
				
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
	}
	
	public List<Turma> listaTodasTurmasProfessor(int professorID) throws ParseException{
		
		String sql = "select codigoTurma, codigoProfessor, nome "
				+ "from turma "
				+ "where codigoProfessor = ? ";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, professorID);
			
			List<Turma> turmas = new ArrayList<Turma>();

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Turma turma = new Turma();
				turma.setCodigoTurma(rs.getInt("codigoTurma"));
				turma.setCodigoProfessor(rs.getInt("codigoProfessor"));
				turma.setNome(rs.getString("nome"));
				
				System.out.println(turma);
				
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
	
	public List<Notas> listaNotasTurma(int turmaId){
		
		String sql = "SELECT n.codigoNotasTurma, n.codigoTurma, t.nome AS nomeTurma, n.codigoAluno, a.nome AS nomeAluno, "
				+ "n.m1, n.m2, n.m3, n.mediaFinal, n.status FROM notasTurma AS n "
				+ "INNER JOIN turma AS t ON n.codigoTurma = t.codigoTurma "
				+ "INNER JOIN aluno AS a ON n.codigoAluno = a.codigoAluno "
				+ "WHERE n.codigoTurma = ?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, turmaId);
			
			List<Notas> notas = new ArrayList<Notas>();

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Notas nota = new Notas();
				nota.setCodigoNotasTurma(rs.getInt("codigoNotasTurma"));
				nota.setCodigoTurma(rs.getInt("codigoTurma"));
				nota.setNomeTurma(rs.getString("nomeTurma"));
				nota.setCodigoAluno(rs.getInt("codigoAluno"));
				nota.setNomeAluno(rs.getString("nomeAluno"));
				nota.setM1(rs.getInt("m1"));
				nota.setM2(rs.getInt("m2"));
				nota.setM3(rs.getInt("m3"));
				nota.setMediaFinal(rs.getInt("mediaFinal"));
				nota.setStatus(rs.getString("status"));
				
				//adicionar objeto a lista
				notas.add(nota);
			}
			rs.close();
			stmt.close();
			System.out.println("Lista de Turmas "+turmaId+" gerada com Sucesso!");
			return notas;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void postarNotas(List<Notas> listaNotasController){
		String sql = "update notasTurma set m1=?, m2=?, m3=? where codigoAluno =? and codigoTurma=?";
		
		for (int i=0; i < listaNotasController.size();i++) {
			try{
				PreparedStatement stmt = this.connection.prepareStatement(sql);;

				stmt.setInt(1, listaNotasController.get(i).getM1());
				stmt.setInt(2, listaNotasController.get(i).getM2());
				stmt.setInt(3, listaNotasController.get(i).getM3());
				stmt.setInt(4, listaNotasController.get(i).getCodigoAluno());
				stmt.setInt(5, listaNotasController.get(i).getCodigoTurma());
				
				stmt.execute();
				stmt.close();

			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
	}
	
	public void fecharTurma(List<Notas> listaNotasController){
		
		TurmaDAO turmaDAO = new TurmaDAO();
		Turma turma = new Turma();
		turma = turmaDAO.buscaPorId(listaNotasController.get(0).getCodigoTurma());
		
		int mediaTurma = turma.getNotaAprovacao()/10;
		
		String sql = "update notasTurma set mediaFinal=?, status=? where codigoAluno =? and codigoTurma=?";
		
		for (int i=0; i < listaNotasController.size();i++) {
			try{
				PreparedStatement stmt = this.connection.prepareStatement(sql);;

				int notaFinal = (listaNotasController.get(i).getM1() + listaNotasController.get(i).getM2() +
						listaNotasController.get(i).getM3())/3;

				String status = new String();
				
				if (notaFinal >= mediaTurma) {
					status = "Aprovado";
				} else {
					status = "Reprovado";
				}
				
				stmt.setInt(1, notaFinal);
				stmt.setString(2, status);
				stmt.setInt(3, listaNotasController.get(i).getCodigoAluno());
				stmt.setInt(4, listaNotasController.get(i).getCodigoTurma());
				
				stmt.execute();
				stmt.close();


			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
	}
}
