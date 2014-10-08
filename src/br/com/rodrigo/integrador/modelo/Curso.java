package br.com.rodrigo.integrador.modelo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Curso {
	
	private int codigoCurso;
	
	@NotNull(message="O nome deve ser preenchido")
	@Size(min=5, message="Descrição deve ter pelo menos 5 carateres")
	private String nome;
	private String descricao;
	private String especialidade1;
	private int codigoEspecialidade1;
	private String especialidade2;
	private int codigoEspecialidade2;
	private String especialidade3;
	private int codigoEspecialidade3;
	
	public String getEspecialidade1() {
		return especialidade1;
	}
	public void setEspecialidade1(String especialidade1) {
		this.especialidade1 = especialidade1;
	}
	public String getEspecialidade2() {
		return especialidade2;
	}
	public void setEspecialidade2(String especialidade2) {
		this.especialidade2 = especialidade2;
	}
	public String getEspecialidade3() {
		return especialidade3;
	}
	public void setEspecialidade3(String especialidade3) {
		this.especialidade3 = especialidade3;
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		System.out.println("chega no modelo");
		this.nome = nome;
	}
	
	public int getCodigoEspecialidade1() {
		return codigoEspecialidade1;
	}
	public void setCodigoEspecialidade1(int codigoEspecialidade1) {
		this.codigoEspecialidade1 = codigoEspecialidade1;
	}
	public int getCodigoEspecialidade2() {
		return codigoEspecialidade2;
	}
	public void setCodigoEspecialidade2(int codigoEspecialidade2) {
		this.codigoEspecialidade2 = codigoEspecialidade2;
	}
	public int getCodigoEspecialidade3() {
		return codigoEspecialidade3;
	}
	public void setCodigoEspecialidade3(int codigoEspecialidade3) {
		this.codigoEspecialidade3 = codigoEspecialidade3;
	}
	
	public int getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
