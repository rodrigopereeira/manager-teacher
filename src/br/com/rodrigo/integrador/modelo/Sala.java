package br.com.rodrigo.integrador.modelo;

public class Sala {
	
	private int codigoSala;
	private String nome;
	private int numeroSala;
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	private int capacidade;
	
	public int getCodigoSala() {
		return codigoSala;
	}
	public void setCodigoSala(int codigoSala) {
		this.codigoSala = codigoSala;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	

}
