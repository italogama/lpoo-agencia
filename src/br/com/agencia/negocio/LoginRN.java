package br.com.agencia.negocio;

import br.com.agencia.dados.LoginDAO;
import br.com.agencia.model.Usuario;

public class LoginRN {
	
	LoginDAO loginDao = null;
	
	public LoginRN() {
		// Chama o construtor da LoginDAO
		loginDao = new LoginDAO();
	}
	
	public Usuario doLogin(Usuario usuario) throws Exception {
		
		if (usuario.getLogin() == null) {
			throw new Exception("Login não informado.");
		}
		if (usuario.getLogin().isEmpty()) {
			throw new Exception("Login não informado.");
		}
		if (usuario.getSenha() == null){
			throw new Exception("Senha não informado.");
		}
		if (usuario.getSenha().isEmpty()) {
			throw new Exception("Senha não informado.");
		}
		// Apos validação, chama metaodo doLogin (DAO)
		return loginDao.doLogin(usuario);
	}
	
	public void validarCpf (String cpf) throws Exception {
		if (cpf.length() != 11) {
			throw new Exception("CPF deve conter 11 Digitos!");
		}
	}

}
