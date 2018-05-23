package br.com.agencia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.agencia.conexaoBanco.ConexaoMySQL;
import br.com.agencia.model.Compra;

public class CompraDAO {

	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	String queryConsultaPelaId = "select * from tbCompra where id=?";
	String queryAdicionarCompra = "insert into tbCompra (login, senha, nome, cpf, perfil) values (?,?,?,?,?) ";
	String queryDeletarCompra = "delete from tbCompra where id=?";
	String queryAlterarCompra = "update tbCompra set login=?, senha=?, nome=?, cpf=?, perfil=? where id=?";

	public CompraDAO() {
		conexao = ConexaoMySQL.conector();
		pst = null;
		rs = null;
	}

	public Compra consultar(String id) {

//		Compra Compra = new Compra();
//
//		try {
//			// Executa consulta de login
//			pst = conexao.prepareStatement(queryConsultaPelaId);
//			pst.setString(1, id);
//			rs = pst.executeQuery();
//
//			if (rs.next()) {
//				compra.setId(rs.getString("id"));
//				compra.setNome(rs.getString("nome"));
//				compra.setLogin(rs.getString("login"));
//				compra.setCpf(rs.getString("cpf"));
//				compra.setSenha(rs.getString("senha"));
//				// a linha abaixo se refere ao combobox
//				Compra.setPerfil(rs.getString("perfil"));
//			} else {
//				// caso ele nao encontre um Compra ele vai limpar os campos e exibir msg de
//				// erro
//				Compra = null;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return null;

	}
}