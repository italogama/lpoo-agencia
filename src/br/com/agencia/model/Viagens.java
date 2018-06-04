package br.com.agencia.model;

public class Viagens {

	private String id;
	private String nome;
	private String login;
	private String cpf;
	private String senha;
	private String perfil;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(Object object) {
		this.perfil = (String) object;
	}

	public Viagens(String id, String nome, String login, String cpf, String senha, String perfil) {
		
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.cpf = cpf;
		this.senha = senha;
		this.perfil = perfil;
	}
	
	public Viagens () {
		
	}
	
	
}
