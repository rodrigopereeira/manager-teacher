package br.com.rodrigo.integrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.integrador.jdbc.ConnectionFactory;
import br.com.rodrigo.integrador.modelo.Aluno;
import br.com.rodrigo.integrador.modelo.Matricula;
import br.com.rodrigo.integrador.modelo.Notas;
import br.com.rodrigo.integrador.modelo.Presenca;
import br.com.rodrigo.integrador.modelo.Turma;

public class AlunoDAO {
	
	Connection connection;
	
	public AlunoDAO () {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Aluno aluno){
		String sql = "insert into aluno (nome, dataNascimento, codigoSexo, "
				+ "codigoEstadoCivil, endereco, numero, bairro, codigoEstado, celular, "
				+ "telefone, email, cpf, rg, senha) " +
					"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getDataNascimento());
			stmt.setInt(3, aluno.getCodigoSexo());
			stmt.setInt(4, aluno.getCodigoEstadoCivil());
			stmt.setString(5, aluno.getEndereco());
			stmt.setString(6, aluno.getNumero());
			stmt.setString(7, aluno.getBairro());
			stmt.setInt(8, aluno.getCodigoEstado());
			stmt.setString(9, aluno.getCelular());
			stmt.setString(10, aluno.getTelefone());
			stmt.setString(11, aluno.getEmail());
			stmt.setString(12, aluno.getCpf());
			stmt.setString(13, aluno.getRg());
			stmt.setString(14, aluno.getSenha());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Aluno> lista(){
		try{
			List<Aluno> alunos = new ArrayList<Aluno>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from aluno");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Aluno aluno = new Aluno();
				aluno.setCodigoAluno(rs.getInt("codigoAluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setDataNascimento(rs.getString("dataNascimento"));
				aluno.setCodigoSexo(rs.getInt("codigoSexo"));
				aluno.setCodigoEstadoCivil(rs.getInt("codigoEstadoCivil"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setNumero(rs.getString("numero"));
				aluno.setBairro(rs.getString("bairro"));
				aluno.setCodigoEstado(rs.getInt("codigoEstado"));
				aluno.setCelular(rs.getString("celular"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEmail(rs.getString("email"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setRg(rs.getString("rg"));
				aluno.setSenha(rs.getString("senha"));
				//adicionar objeto a lista
				alunos.add(aluno);
			}
			rs.close();
			stmt.close();

			return alunos;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Aluno aluno){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from aluno where codigoAluno = ?");
			
			stmt.setInt(1, aluno.getCodigoAluno());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Aluno buscaPorId(int id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select codigoAluno, nome, "
					+ "CONVERT(char(10),dataNascimento,103) AS dataNascimento, "
					+ "codigoSexo, codigoEstadoCivil, endereco, numero, bairro, codigoEstado, "
					+ "celular, telefone, email, cpf, rg, senha from aluno");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getInt("codigoAluno"))
				{
					//criando objeto tarefa
					Aluno aluno = new Aluno();
					aluno.setCodigoAluno(rs.getInt("codigoAluno"));
					aluno.setNome(rs.getString("nome"));
					aluno.setDataNascimento(rs.getString("dataNascimento"));
					aluno.setCodigoSexo(rs.getInt("codigoSexo"));
					aluno.setCodigoEstadoCivil(rs.getInt("codigoEstadoCivil"));
					aluno.setEndereco(rs.getString("endereco"));
					aluno.setNumero(rs.getString("numero"));
					aluno.setBairro(rs.getString("bairro"));
					aluno.setCodigoEstado(rs.getInt("codigoEstado"));
					aluno.setCelular(rs.getString("celular"));
					aluno.setTelefone(rs.getString("telefone"));
					aluno.setEmail(rs.getString("email"));
					aluno.setCpf(rs.getString("cpf"));
					aluno.setRg(rs.getString("rg"));
					aluno.setSenha(rs.getString("senha"));

					return aluno;
				}
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}	
	}
	
	public void altera(Aluno aluno){
		String sql = "update aluno set nome=?, dataNascimento=?, codigoSexo=?, codigoEstadoCivil=?, endereco=?, "
				+ "numero=?, bairro=?, codigoEstado=?, celular=?, telefone=?, email=?, cpf=?, "
				+ "rg=?, senha=? where codigoAluno=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getDataNascimento());
			stmt.setInt(3, aluno.getCodigoSexo());
			stmt.setInt(4, aluno.getCodigoEstadoCivil());
			stmt.setString(5, aluno.getEndereco());
			stmt.setString(6, aluno.getNumero());
			stmt.setString(7, aluno.getBairro());
			stmt.setInt(8, aluno.getCodigoEstado());
			stmt.setString(9, aluno.getCelular());
			stmt.setString(10, aluno.getTelefone());
			stmt.setString(11, aluno.getEmail());
			stmt.setString(12, aluno.getCpf());
			stmt.setString(13, aluno.getRg());
			stmt.setString(14, aluno.getSenha());
			stmt.setInt(15, aluno.getCodigoAluno());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Matricula> listaTurmas(Aluno alunoID){
		
		String sql = "select a.nome as nomeAluno, a.codigoAluno, t.nome as nomeTurma, "
				+ "convert(char(10),m.diaMatricula,103) AS diaMatricula, "
				+ "convert(char(5),m.horaMatricula,108) as horaMatricula "
				+ "from MatriculaAluno as m "
				+ "inner join turma as t on m.codigoTurma = t.codigoTurma "
				+ "inner join aluno as a on m.codigoAluno = a.codigoAluno "
				+ "where m.codigoAluno = ?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, alunoID.getCodigoAluno());
			
			List<Matricula> matriculas = new ArrayList<Matricula>();

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Matricula matricula = new Matricula();
				matricula.setNomeAluno(rs.getString("nomeAluno"));
				matricula.setCodigoAluno(rs.getInt("codigoAluno"));
				matricula.setNomeTurma(rs.getString("nomeTurma"));
				matricula.setDiaMatricula(rs.getString("diaMatricula"));
				matricula.setHoraMatricula(rs.getString("horaMatricula"));

				//adicionar objeto a lista
				matriculas.add(matricula);
			}
			rs.close();
			stmt.close();

			return matriculas;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}

	public List<Notas> listaNotasAluno(int alunoID){
		
		String sql = "select t.nome as nomeTurma, n.m1, n.m2, n.m3, n.mediaFinal, n.status "
				+ "from notasTurma as n "
				+ "inner join turma as t on n.codigoTurma = t.codigoTurma "
				+ "where codigoAluno = ?";

		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, alunoID);
			
			List<Notas> notas = new ArrayList<Notas>();

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Notas nota = new Notas();
				nota.setNomeTurma(rs.getString("nomeTurma"));
				nota.setM1(rs.getInt("m1"));
				nota.setM2(rs.getInt("m2"));
				nota.setM3(rs.getInt("m3"));
				nota.setMediaFinal(rs.getInt("mediaFinal"));
				nota.setStatus(rs.getString("status"));
				
				int m1 = rs.getInt("m1");
				int m2 = rs.getInt("m2");
				int m3 = rs.getInt("m3");
				
				nota.setMediaParcial((m1+m2+m3)/3);

				//adicionar objeto a lista
				notas.add(nota);
			}
			rs.close();
			stmt.close();
			
			return notas;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public List<Turma> listaTurmasAluno(int alunoID){
		
		String sql = "select distinct p.codigoTurma, t.nome as nomeTurma "
				+ "from presencaAluno as p "
				+ "inner join turma as t on p.codigoTurma = t.codigoTurma "
				+ "where p.codigoAluno = ?  ";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, alunoID);
			
			List<Turma> turmas = new ArrayList<Turma>();

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Turma turma = new Turma();
				turma.setCodigoTurma(rs.getInt("codigoTurma"));
				turma.setNome(rs.getString("nomeTurma"));

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
	
	public List<Presenca> listaPresencasTurma(int alunoID, int codigoTurma){
		
		String sql = "select convert(char(10),data,103) as data, presente "
				+ "from presencaAluno "
				+ "where codigoAluno = ? and codigoTurma = ? ";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, alunoID);
			stmt.setInt(2, codigoTurma);
			
			List<Presenca> presencas = new ArrayList<Presenca>();

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Presenca presenca = new Presenca();
				presenca.setData(rs.getString("data"));
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
}
