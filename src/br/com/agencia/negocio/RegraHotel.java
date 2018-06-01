package br.com.agencia.negocio;

import java.sql.ResultSet;

import br.com.agencia.dados.HotelDAO;
import br.com.agencia.model.Hotel;

public class RegraHotel {

	private HotelDAO hotelDao;

	public RegraHotel() {
		hotelDao = new HotelDAO();
	}

	public ResultSet consultar() {

		return hotelDao.consultar();

	}
	
	public ResultSet consultarOrdenado() {

		return hotelDao.consultarOrdenado();

	}

}
