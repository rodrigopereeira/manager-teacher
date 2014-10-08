package br.com.rodrigo.integrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.integrador.jdbc.ConnectionFactory;
import br.com.rodrigo.integrador.modelo.Secretaria;

public class SecretariaDAO {

	Connection connection;
	
	public SecretariaDAO () {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Secretaria secretaria){
		String sql = "insert into secretaria (nome, dataNascimento, codigoSexo, "
				+ "codigoEstadoCivil, endereco, numero, bairro, codigoEstado, celular, "
				+ "telefone, email, cpf, rg, login, senha) " +
					"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, secretaria.getNome());
			stmt.setString(2, secretaria.getDataNascimento());
			stmt.setInt(3, secretaria.getCodigoSexo());
			stmt.setInt(4, secretaria.getCodigoEstadoCivil());
			stmt.setString(5, secretaria.getEndereco());
			stmt.setString(6, secretaria.getNumero());
			stmt.setString(7, secretaria.getBairro());
			stmt.setInt(8, secretaria.getCodigoEstado());
			stmt.setString(9, secretaria.getCelular());
			stmt.setString(10, secretaria.getTelefone());
			stmt.setString(11, secretaria.getEmail());
			stmt.setString(12, secretaria.getCpf());
			stmt.setString(13, secretaria.getRg());
			stmt.setString(14, secretaria.getLogin());
			stmt.setString(15, secretaria.getSenha());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Secretaria> lista(){
		try{
			List<Secretaria> secretarias = new ArrayList<Secretaria>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from secretaria");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Secretaria secretaria = new Secretaria();
				secretaria.setCodigoSecretaria(rs.getInt("codigoSecretaria"));
				secretaria.setNome(rs.getString("nome"));
				secretaria.setDataNascimento(rs.getString("dataNascimento"));
				secretaria.setCodigoSexo(rs.getInt("codigoSexo"));
				secretaria.setCodigoEstadoCivil(rs.getInt("codigoEstadoCivil"));
				secretaria.setEndereco(rs.getString("endereco"));
				secretaria.setNumero(rs.getString("numero"));
				secretaria.setBairro(rs.getString("bairro"));
				secretaria.setCodigoEstado(rs.getInt("codigoEstado"));
				secretaria.setCelular(rs.getString("celular"));
				secretaria.setTelefone(rs.getString("telefone"));
				secretaria.setEmail(rs.getString("email"));
				secretaria.setCpf(rs.getString("cpf"));
				secretaria.setRg(rs.getString("rg"));
				secretaria.setLogin(rs.getString("login"));
				secretaria.setSenha(rs.getString("senha"));
				//adicionar objeto a lista
				secretarias.add(secretaria);
			}
			rs.close();
			stmt.close();

			return secretarias;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Secretaria secretaria){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from secretaria where codigoSecretaria = ?");
			
			stmt.setInt(1, secretaria.getCodigoSecretaria());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Secretaria buscaPorId(int id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select codigoSecretaria, "
					+ "nome, "
					+ "CONVERT(char(10),dataNascimento,103) AS dataNascimento, "
					+ "codigoSExo, codigoEstadoCivil, endereco, numero, bairro, "
					+ "codigoEstado, celular, telefone, email, cpf, rg, login, senha from secretaria");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getInt("codigoSecretaria"))
				{
					//criando objeto tarefa
					Secretaria secretaria = new Secretaria();
					secretaria.setCodigoSecretaria(rs.getInt("codigoSecretaria"));
					secretaria.setNome(rs.getString("nome"));
					secretaria.setDataNascimento(rs.getString("dataNascimento"));
					secretaria.setCodigoSexo(rs.getInt("codigoSexo"));
					secretaria.setCodigoEstadoCivil(rs.getInt("codigoEstadoCivil"));
					secretaria.setEndereco(rs.getString("endereco"));
					secretaria.setNumero(rs.getString("numero"));
					secretaria.setBairro(rs.getString("bairro"));
					secretaria.setCodigoEstado(rs.getInt("codigoEstado"));
					secretaria.setCelular(rs.getString("celular"));
					secretaria.setTelefone(rs.getString("telefone"));
					secretaria.setEmail(rs.getString("email"));
					secretaria.setCpf(rs.getString("cpf"));
					secretaria.setRg(rs.getString("rg"));
					secretaria.setLogin(rs.getString("login"));
					secretaria.setSenha(rs.getString("senha"));

					return secretaria;
				}
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}	
	}
	
	public void altera(Secretaria secretaria){
		String sql = "update secretaria set nome=?, dataNascimento=?, codigoSexo=?, codigoEstadoCivil=?, endereco=?, "
				+ "numero=?, bairro=?, codigoEstado=?, celular=?, telefone=?, email=?, cpf=?, "
				+ "rg=?, login=?, senha=? where codigoSecretaria=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, secretaria.getNome());
			stmt.setString(2, secretaria.getDataNascimento());
			stmt.setInt(3, secretaria.getCodigoSexo());
			stmt.setInt(4, secretaria.getCodigoEstadoCivil());
			stmt.setString(5, secretaria.getEndereco());
			stmt.setString(6, secretaria.getNumero());
			stmt.setString(7, secretaria.getBairro());
			stmt.setInt(8, secretaria.getCodigoEstado());
			stmt.setString(9, secretaria.getCelular());
			stmt.setString(10, secretaria.getTelefone());
			stmt.setString(11, secretaria.getEmail());
			stmt.setString(12, secretaria.getCpf());
			stmt.setString(13, secretaria.getRg());
			stmt.setString(14, secretaria.getLogin());
			stmt.setString(15, secretaria.getSenha());
			stmt.setInt(16, secretaria.getCodigoSecretaria());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
