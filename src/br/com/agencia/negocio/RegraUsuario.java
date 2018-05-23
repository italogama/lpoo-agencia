package br.com.agencia.negocio;

import br.com.agencia.dados.UsuarioDAO;
import br.com.agencia.model.Usuario;

public class RegraUsuario {

	private UsuarioDAO usuarioDao;

	public RegraUsuario() {
		usuarioDao = new UsuarioDAO();
	}

	public Usuario consultaUsuario(String id) {

		return usuarioDao.consultar(id);

	}

	/**
	 * Método responsável por alterar ou inserir um usuário Caso o ID esteja
	 * preenchido considero que o usuário já existe então só faço alterar utilizando
	 * o código informado
	 * 
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public int adicionarOrAlterar(Usuario usuario) throws Exception {

		if (usuario.getLogin().isEmpty()) {
			throw new Exception("Login está vazio");
		} else if (usuario.getSenha().isEmpty()) {
			throw new Exception("Senha está vazio");
		} else if (usuario.getNome().isEmpty()) {
			throw new Exception("Nome está vazio");
		} else if (usuario.getCpf().isEmpty()) {
			throw new Exception("CPF está vazio");
		} else if (usuario.getCpf().length() != 11) {
			throw new Exception("CPF deve conter 11 Digitos!");
		} else if (!usuario.getCpf().matches("[0-9]*")) {
			throw new Exception("CPF Invalido, deve conter apenas numeros!");
		}
		if (usuario.getId() != null && !usuario.getId().isEmpty()) {
			return usuarioDao.alterar(usuario);
		} else {
			return usuarioDao.adicionar(usuario);
		}
	}

	public int remover(String id) {
		return usuarioDao.remover(id);

	}

}
