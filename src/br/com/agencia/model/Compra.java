package br.com.agencia.model;

import java.util.Date;

public class Compra {
	private int id;
	private int idUsuario;
	private int idPacote;
	private Date dtCompra;
	private double valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}

	public Date getDtCompra() {
		return dtCompra;
	}

	public void setDtCompra(Date dtCompra) {
		this.dtCompra = dtCompra;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
