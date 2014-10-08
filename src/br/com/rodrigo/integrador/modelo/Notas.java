package br.com.rodrigo.integrador.modelo;

import java.util.List;

public class Notas {
	
	private int codigoNotasTurma;
	private int codigoTurma;
	private String nomeTurma;
	private int codigoAluno;
	private String nomeAluno;
	private int m1;
	private int m2;
	private int m3;
	private int mediaFinal;
	private int mediaParcial;
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMediaParcial() {
		return mediaParcial;
	}
	public void setMediaParcial(int mediaParcial) {
		this.mediaParcial = mediaParcial;
	}
	public int getMediaFinal() {
		return mediaFinal;
	}
	public void setMediaFinal(int mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
	private List<Notas> listaNotas;
	
	public List<Notas> getListaNotas() {
		return listaNotas;
	}
	public void setListaNotas(List<Notas> listaNotas) {
		this.listaNotas = listaNotas;
	}
	public int getCodigoNotasTurma() {
		return codigoNotasTurma;
	}
	public void setCodigoNotasTurma(int codigoNotasTurma) {
		this.codigoNotasTurma = codigoNotasTurma;
	}
	public int getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(int codigoTurma) {
		this.codigoTurma = codigoTurma;
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
	public int getM1() {
		return m1;
	}
	public void setM1(int m1) {
		this.m1 = m1;
	}
	public int getM2() {
		return m2;
	}
	public void setM2(int m2) {
		this.m2 = m2;
	}
	public int getM3() {
		return m3;
	}
	public void setM3(int m3) {
		this.m3 = m3;
	}

}
