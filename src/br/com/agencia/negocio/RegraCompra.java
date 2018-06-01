package br.com.agencia.negocio;

import br.com.agencia.dados.CompraDAO;
import br.com.agencia.model.Compra;

public class RegraCompra {

	private CompraDAO compraDao;

	public RegraCompra() {
		compraDao = new CompraDAO();
	}

	public int cadastrar(Compra compra) {
		return compraDao.cadastrar(compra);
	}

}
