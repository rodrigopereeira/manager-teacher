package br.com.rodrigo.integrador.modelo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Documento {
	
	CommonsMultipartFile documento;
	String nomeArquivo;
	int codigoTurma;

	public int getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(int codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public CommonsMultipartFile getDocumento() {
		return documento;
	}

	public void setDocumento(CommonsMultipartFile documento) {
		this.documento = documento;
	}

}
