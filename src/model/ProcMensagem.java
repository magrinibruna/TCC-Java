package model;

import java.sql.Date;

public class ProcMensagem {
	
	private int recebido;
	private int envio;
	private String envia;
	private Date data;
	private String assunto;
	private String descricao;

	public int getRecebido() {
		return recebido;
	}
	public void setRecebido(int recebido) {
		this.recebido = recebido;
	}
	public int getEnvio() {
		return envio;
	}
	public void setEnvio(int envio) {
		this.envio = envio;
	}
	public String getEnvia() {
		return envia;
	}
	public void setEnvia(String envia) {
		this.envia = envia;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
