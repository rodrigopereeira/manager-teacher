package br.com.rodrigo.integrador.modelo;

public class SalaOcupada {

	private int codigoSalaOcupada;
	private String nomeSala;
	private int codigoSala;
	private String nomeTurma;
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	private int codigoTurma;
	private String dia;
	private String dataInicial;
	private String dataTermino;
	private String horaInicio;
	private String horaTermino;
	public int getCodigoSalaOcupada() {
		return codigoSalaOcupada;
	}
	public void setCodigoSalaOcupada(int codigoSalaOcupada) {
		this.codigoSalaOcupada = codigoSalaOcupada;
	}
	public int getCodigoSala() {
		return codigoSala;
	}
	public void setCodigoSala(int codigoSala) {
		this.codigoSala = codigoSala;
	}
	public int getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(int codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}
	
}
