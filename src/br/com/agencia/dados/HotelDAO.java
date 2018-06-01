package br.com.agencia.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import br.com.agencia.conexaoBanco.ConexaoMySQL;
import br.com.agencia.model.Hotel;

public class HotelDAO {

	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	String queryConsulta = "select * from tbhotel";
	String queryConsultaOrder = "select * from tbhotel ORDER BY hotel_diaria";
	// ORDER BY hotel_diaria";

	public HotelDAO() {
		conexao = ConexaoMySQL.conector();
		pst = null;
		rs = null;
	}

	public ResultSet consultar() {

		try {
			// Executa consulta de hotel
			pst = conexao.prepareStatement(queryConsulta);
			rs = pst.executeQuery();

		} catch (Exception e) {

		}

		return rs;
	}

	public ResultSet consultarOrdenado() {

		try {
			// Executa consulta de hotel
			pst = conexao.prepareStatement(queryConsultaOrder);
			rs = pst.executeQuery();

		} catch (Exception e) {

		}

		return rs;
	}

}
