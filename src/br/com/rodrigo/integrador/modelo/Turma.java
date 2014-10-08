package br.com.rodrigo.integrador.modelo;


public class Turma {
	
	private int codigoTurma;
	private int codigoCurso;
	private String nomeCurso;
	private int codigoProfessor;
	private String nomeProfessor;
	private int codigoSala;
	private String nomeSala;
	private String nome;
	private int vagas;
	private String horaInicio;
	private String horaTermino;
	private String dataInicio;
	private String dataTermino;
	private int notaAprovacao;
	private int frequenciaMinima;
	private String dia;
	private String descricao;
	private String nomeAluno;
	private int codigoAluno;
	

	private boolean professorOcupado;

	private boolean salaOcupada;
	
	public boolean isProfessorOcupado() {
		return professorOcupado;
	}
	public void setProfessorOcupado(boolean professorOcupado) {
		this.professorOcupado = professorOcupado;
	}
	public boolean isSalaOcupada() {
		return salaOcupada;
	}
	public void setSalaOcupada(boolean salaOcupada) {
		this.salaOcupada = salaOcupada;
	}
	public int getCodigoAluno() {
		return codigoAluno;
	}
	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		
		
		
		this.dia = dia;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	
	public int getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(int codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public int getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public int getCodigoProfessor() {
		return codigoProfessor;
	}
	public void setCodigoProfessor(int codigoProfessor) {
		this.codigoProfessor = codigoProfessor;
	}
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
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
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
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
		
		setDia("TESTE DIA");
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public int getNotaAprovacao() {
		return notaAprovacao;
	}
	public void setNotaAprovacao(int notaAprovacao) {
		this.notaAprovacao = notaAprovacao;
	}
	public int getFrequenciaMinima() {
		return frequenciaMinima;
	}
	public void setFrequenciaMinima(int frequenciaMinima) {
		this.frequenciaMinima = frequenciaMinima;
	}

}
