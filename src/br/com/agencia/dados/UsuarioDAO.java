package br.com.agencia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.agencia.conexaoBanco.ConexaoMySQL;
import br.com.agencia.model.Usuario;

public class UsuarioDAO {

	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	String queryConsultaPelaId = "select * from tbusuario where id=?";
	String queryAdicionarUsuario = "insert into tbusuario (login, senha, nome, cpf, perfil) values (?,?,?,?,?) ";
	String queryDeletarUsuario = "delete from tbusuario where id=?";
	String queryAlterarUsuario = "update tbusuario set login=?, senha=?, nome=?, cpf=?, perfil=? where id=?";

	public UsuarioDAO() {
		conexao = ConexaoMySQL.conector();
		pst = null;
		rs = null;
	}

	public Usuario consultar(String id) {

		Usuario usuario = new Usuario();

		try {
			// Executa consulta de login
			pst = conexao.prepareStatement(queryConsultaPelaId);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				usuario.setId(rs.getString("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setSenha(rs.getString("senha"));
				// a linha abaixo se refere ao combobox
				usuario.setPerfil(rs.getString("perfil"));
			} else {
				// caso ele nao encontre um usuario ele vai limpar os campos e exibir msg de
				// erro
				usuario = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;

	}

	public int adicionar(Usuario usuario) throws Exception {

		try {
			pst = conexao.prepareStatement(queryAdicionarUsuario);
			// pst.setString(1,txtUsuId.getText());
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getNome());
			pst.setString(4, usuario.getCpf());
			pst.setString(5, usuario.getPerfil());
			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public int remover(String id) {

		try {
			pst = conexao.prepareStatement(queryDeletarUsuario);
			pst.setString(1, id);
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int alterar(Usuario usuario) {

		try {
			pst = conexao.prepareStatement(queryAlterarUsuario);
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getNome());
			pst.setString(4, usuario.getCpf());
			pst.setString(5, usuario.getPerfil());
			pst.setString(6, usuario.getId());

			return pst.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return 0;
	}
}
