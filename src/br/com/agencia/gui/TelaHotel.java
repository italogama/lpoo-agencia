package br.com.agencia.gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.agencia.conexaoBanco.ConexaoMySQL;
import br.com.agencia.model.Hotel;
import br.com.agencia.negocio.RegraHotel;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaHotel extends JFrame {

	RegraHotel regraHotel = null;

	private JPanel contentPane;
	private JTable table;

	public TelaHotel() {

		regraHotel = new RegraHotel();
		Hotel hotel = new Hotel();

		setTitle(".: Hoteis :.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 599, 416);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 573, 272);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		
		consulta(regraHotel.consultar());

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consulta(regraHotel.consultar());
			}
		});
		btnNewButton.setBounds(160, 56, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Mais Barato");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta(regraHotel.consultarOrdenado());
			}
		});
		btnNewButton_1.setBounds(321, 56, 109, 23);
		contentPane.add(btnNewButton_1);

		setResizable(false);
	}
	
	public void consulta(ResultSet rs) {
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("ID");
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Nome do Hotel");
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Rua");
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Nº");
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("Bairro");
		table.getColumnModel().getColumn(4).setPreferredWidth(45);
		table.getTableHeader().getColumnModel().getColumn(5).setHeaderValue("Cidade");
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getTableHeader().getColumnModel().getColumn(6).setHeaderValue("Reputacao");
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getTableHeader().getColumnModel().getColumn(7).setHeaderValue("Valor Diaria");
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		repaint();
	}

}
