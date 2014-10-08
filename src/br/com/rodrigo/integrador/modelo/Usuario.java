package br.com.rodrigo.integrador.modelo;

public class Usuario {
	private String login;
	private String senha;
	private String nome;
	private int identificacao;
	public int getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}

	private int codGrupoUsuario;

	public int getCodGrupoUsuario() {
		return codGrupoUsuario;
	}
	public void setCodGrupoUsuario(int codGrupoUsuario) {
		this.codGrupoUsuario = codGrupoUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
