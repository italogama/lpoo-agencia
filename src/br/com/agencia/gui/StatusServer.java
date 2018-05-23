package br.com.agencia.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import br.com.agencia.conexaoBanco.ConexaoMySQL;

public class StatusServer implements Runnable  {

	private JLabel lblStatus;
	private ImageIcon imgConect = new ImageIcon("img/iconConec.png");
	private ImageIcon imgDescon = new ImageIcon("img/iconDescon.png");
	
	public StatusServer(JLabel jLabel) {
		this.lblStatus = jLabel;
	}
	
	@Override
	public void run() {
		while(true) {
			
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (ConexaoMySQL.conector() != null) {
				lblStatus.setIcon(imgConect);
			} else {
				lblStatus.setIcon(imgDescon);
			}
		}
		
	}

}