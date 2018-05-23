package br.com.agencia.model;

import java.util.Date;

public class Compra {
	private int id;
	private String idUsuario;
	private String idPacote;
	private Date dtCompra;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdPacote() {
		return idPacote;
	}
	public void setIdPacote(String idPacote) {
		this.idPacote = idPacote;
	}
	public Date getDtCompra() {
		return dtCompra;
	}
	public void setDtCompra(Date dtCompra) {
		this.dtCompra = dtCompra;
	}
	
}
