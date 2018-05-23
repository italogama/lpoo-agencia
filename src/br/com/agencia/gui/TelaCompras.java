package br.com.agencia.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCompras extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public TelaCompras() {
		setTitle(".: Compra de Pacotes :.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 599, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(0, 204, 0));
		btnConfirmar.setBounds(327, 320, 102, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(457, 320, 89, 23);
		contentPane.add(btnVoltar);
		
		table = new JTable();
		table.setBounds(25, 61, 521, 240);
		contentPane.add(table);
		String [] colunas = {"Nome", "Telefone", "Email"};
	}
}
