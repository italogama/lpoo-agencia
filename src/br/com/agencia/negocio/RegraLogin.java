package br.com.agencia.negocio;

public class RegraLogin {
	
	public void validarDadosLogin(LoginRN loginRN) throws LoginException{
//		if (loginRN.getUsuario().equals("")) {
//			//Lançar a exceção
//			throw new LoginException("Usuário precisa ser preenchido");
//			}
		//Codigo
	}
	
	public void efetuarLogin(LoginRN loginRN) throws LoginException{
		validarDadosLogin(loginRN);
		//repositorio
		
	}
}