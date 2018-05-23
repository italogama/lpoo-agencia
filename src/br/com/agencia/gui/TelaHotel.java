package br.com.agencia.gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class TelaHotel extends JFrame {
	
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTable table;

	private void consultar() {
		String sql = "select * from tbusuario where id=?";

		try {
			pst = conexao.prepareStatement(sql);
			// pst.setString(1, usuario.getId());
			rs = pst.executeQuery();

			if (rs.next()) {

			} else {
				// caso ele nao encontre um usuario ele vai limpar os campos e exibir msg de erro

			
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public TelaHotel() {
		setTitle(".: Hoteis :.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 599, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pesquisa de Hoteis");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(175, 20, 138, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Disponiveis");
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(311, 22, 80, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Todos");
		btnNewButton.setBounds(160, 56, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Mais Barato");
		btnNewButton_1.setBounds(321, 56, 109, 23);
		contentPane.add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(10, 104, 573, 272);
		contentPane.add(table);
		setResizable(false);
	}
}
