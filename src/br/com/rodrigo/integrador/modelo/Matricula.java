package br.com.rodrigo.integrador.modelo;

public class Matricula {

	private int codigoMatricula;
	private String nomeAluno;
	private int codigoAluno;
	private String nomeTurma;
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	private int codigoTurma;
	private String diaMatricula;
	private String horaMatricula;
	public int getCodigoMatricula() {
		return codigoMatricula;
	}
	public void setCodigoMatricula(int codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}
	public int getCodigoAluno() {
		return codigoAluno;
	}
	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	public int getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(int codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public String getDiaMatricula() {
		return diaMatricula;
	}
	public void setDiaMatricula(String diaMatricula) {
		this.diaMatricula = diaMatricula;
	}
	public String getHoraMatricula() {
		return horaMatricula;
	}
	public void setHoraMatricula(String horaMatricula) {
		this.horaMatricula = horaMatricula;
	}
}
