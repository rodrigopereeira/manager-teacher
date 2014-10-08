package br.com.rodrigo.integrador.modelo;

import java.util.List;

public class Presenca {
	
	private int codigoTurma;
	private String nomeTurma;
	private int codigoAluno;
	private String nomeAluno;
	private String data;
	private String dia;
	private String hora;
	private String presenca;
	private List<Presenca> listaPresencas;
	
	public List<Presenca> getListaPresencas() {
		return listaPresencas;
	}
	public void setListaPresencas(List<Presenca> listaPresencas) {
		this.listaPresencas = listaPresencas;
	}
	public String getPresenca() {
		return presenca;
	}
	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	public int getCodigoAluno() {
		return codigoAluno;
	}
	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	
	public int getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(int codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

}
