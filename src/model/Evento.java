package model;

import java.sql.Date;

public class Evento {
	
	/* jscrollpanel e dentro dele o jtable */
	
	int idEvento;
	String tituloEvento;
	String descricaoEvento;
	Date dataEvento;
	String anoLetivoEvento;
	
	
	public void setAnoLetivoEvento(String anoLetivoEvento) {
		this.anoLetivoEvento = anoLetivoEvento;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getTituloEvento() {
		return tituloEvento;
	}
	public void setTituloEvento(String tituloEvento) {
		this.tituloEvento = tituloEvento;
	}
	public String getDescricaoEvento() {
		return descricaoEvento;
	}
	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	
	public String getAnoLetivoEvento() {
		return anoLetivoEvento;
	}


}
