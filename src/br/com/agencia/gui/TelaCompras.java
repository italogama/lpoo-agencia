package br.com.agencia.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;

public class TelaCompras extends JFrame {

	private JPanel contentPane;
	String[] columns = {"First Name", "Surname", "Country"
			, "Event", "Place", "Time",};
	
	Object[][] data = {
			{"César Cielo", "Filho", "Brazil", "50m freestyle",1 , "21.30"},
			{"Amaury", "Leveaux", "France", "50m freestyle", 2, "21.45"},
			{"Eamon", "Sullivan", "Australia", "100m freestyle", 2, "47.32"},
			{"Michael", "Phelps", "USA", "200m freestyle", 1, "1:42.96"},
			{"Ryan", "Lochte", "USA", "200m backstroke", 1, "1:53.94",},
			{"Hugues", "Duboscq", "France", "100m breaststroke", 3, "59.37"}
			};
	private JTable table;
	private JScrollPane scrollPane;

	public TelaCompras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 503, 235);
		contentPane.add(scrollPane);
		
		table = new JTable(data, columns);
		scrollPane.setViewportView(table);
		
		
	
	}
}
