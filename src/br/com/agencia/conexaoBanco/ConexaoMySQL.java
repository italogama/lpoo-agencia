package br.com.agencia.conexaoBanco;

//Classes necessárias para uso de Banco de br.com.agencia.dados //

import java.sql.*;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ConexaoMySQL {
	
	static java.sql.Connection conexao = null;
	
	public static Connection conector() {
		// a linha abaixo "chama" o driver
		String driver = "com.mysql.jdbc.Driver";
		// Armazenando informações referente ao banco
		String url="jdbc:mysql://localhost:3306/dbriel";
		String user="root";
		String password="";
		// Estalebecendo a conexão com o banco
		
		try {
			Class.forName(driver);
			if(conexao == null) {
				conexao = DriverManager.getConnection(url, user, password);
			}
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void closeConnection() {
		if(conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
