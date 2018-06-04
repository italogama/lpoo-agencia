package br.com.agencia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import br.com.agencia.conexaoBanco.ConexaoMySQL;
import br.com.agencia.model.Compra;
import br.com.agencia.model.Sessao;

public class CompraDAO {

	private Connection conexao = null;
	private PreparedStatement pst = null;
	String queryConsultaPelaId = "select * from tbCompra where id=?";
	String queryAdicionarCompra = "INSERT INTO tbcompra_viagens (usuario,pct_id,dt_compra,pct_valor)VALUES(?,?,?,?)";
	String queryDeletarCompra = "delete from tbCompra where id=?";
	String queryAlterarCompra = "update tbCompra set login=?, senha=?, nome=?, cpf=?, perfil=? where id=?";

	public CompraDAO() {
		conexao = ConexaoMySQL.conector();
		pst = null;
	}

	public int cadastrar(Compra compra) {

		try {
			// Executa consulta de login
			pst = conexao.prepareStatement(queryAdicionarCompra);
			pst.setInt(1, compra.getIdUsuario());
			pst.setInt(2, compra.getIdPacote());
			pst.setDate(3, new java.sql.Date(new Date().getTime()) );
			pst.setDouble(4, compra.getValor());
			return pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}
	
	public ResultSet retornarUltimasCompras(String idUsuario) {
		
		String query = "SELECT " + 
				"    p.pct_destino, v.dt_compra, v.pct_valor" + 
				" FROM " + 
				"    tbcompra_viagens v" + 
				"        INNER JOIN" + 
				"    tbpct_viagem p ON p.pct_id = v.pct_id" + 
				"    INNER JOIN" + 
				"    tbusuario u ON u.id = v.usuario" + 
				"    where u.id = ?" + 
				"";
		
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(query);
			pst.setString(1, idUsuario);
			return pst.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}