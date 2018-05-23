package br.com.agencia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.agencia.conexaoBanco.ConexaoMySQL;
import br.com.agencia.model.Usuario;

public class LoginDAO {
	
	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	String sql = "select * from tbusuario where login=? and senha=?";
	
	public LoginDAO() {
		conexao = ConexaoMySQL.conector();
		pst = null;
		rs = null;
	}
	
	// Recebe as informações e passa como parametro
	public Usuario doLogin(Usuario usuario) throws Exception {
		
		try {
			// Executa consulta de login
			pst = conexao.prepareStatement(sql);
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// se existir usuario etc
			if (rs.next()) {
				// a linha abaixo obtem o conteudo do campo perfil da tab cliente
				usuario.setPerfil(rs.getString("perfil"));
				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setId(rs.getString("id"));
			}else {
				throw new Exception("Usuário não existe ou as informações não são validas.");
			}
				

		return usuario;
	}
}
