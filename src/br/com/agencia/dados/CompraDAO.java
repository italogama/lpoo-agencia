package br.com.agencia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import br.com.agencia.conexaoBanco.ConexaoMySQL;
import br.com.agencia.model.Compra;

public class CompraDAO {

	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	String queryConsultaPelaId = "select * from tbCompra where id=?";
	String queryAdicionarCompra = "INSERT INTO tbcompra_viagens (usuario,pct_id,dt_compra,pct_valor)VALUES(?,?,?,?)";
	String queryDeletarCompra = "delete from tbCompra where id=?";
	String queryAlterarCompra = "update tbCompra set login=?, senha=?, nome=?, cpf=?, perfil=? where id=?";

	public CompraDAO() {
		conexao = ConexaoMySQL.conector();
		pst = null;
		rs = null;
	}

	public int cadastrar(Compra compra) {

		try {
			// Executa consulta de login
			pst = conexao.prepareStatement(queryAdicionarCompra);
			pst.setInt(1, compra.getIdUsuario());
			pst.setInt(2, compra.getIdPacote());
			pst.setDate(3, (java.sql.Date) new Date());
			pst.setDouble(4, compra.getValor());
			return pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}
}