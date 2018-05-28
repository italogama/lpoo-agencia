package br.com.agencia.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPerfil extends JFrame {

	public JPanel contentPane;
	public static JTextField textUsuNome;
	public static JTextField textUsuCpf;
	public static JTextField textUsuLogin;
	public static JTextField textUsuSenha;
	
	public TelaPerfil() {
		setTitle(".: Painel :.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(480, 230, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPainelDoUsurio = new JLabel("Painel do Usu\u00E1rio");
		lblPainelDoUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPainelDoUsurio.setBounds(131, 11, 144, 37);
		contentPane.add(lblPainelDoUsurio);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 58, 46, 25);
		contentPane.add(lblNome);
		
		JLabel lblLogin = new JLabel("Cpf:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(10, 87, 46, 25);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 119, 46, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 150, 46, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("img\\userprof.png"));
		lblNewLabel_2.setBounds(250, 46, 144, 142);
		contentPane.add(lblNewLabel_2);
		
		textUsuNome = new JTextField();
		textUsuNome.setEditable(false);
		textUsuNome.setBounds(61, 62, 164, 20);
		contentPane.add(textUsuNome);
		textUsuNome.setColumns(10);
		
		textUsuCpf = new JTextField();
		textUsuCpf.setEditable(false);
		textUsuCpf.setBounds(60, 91, 165, 20);
		contentPane.add(textUsuCpf);
		textUsuCpf.setColumns(10);
		
		textUsuLogin = new JTextField();
		textUsuLogin.setEditable(false);
		textUsuLogin.setBounds(61, 123, 164, 20);
		contentPane.add(textUsuLogin);
		textUsuLogin.setColumns(10);
		
		textUsuSenha = new JTextField();
		textUsuSenha.setEditable(false);
		textUsuSenha.setBounds(61, 154, 164, 20);
		contentPane.add(textUsuSenha);
		textUsuSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(226, 203, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(325, 203, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPerfil.textUsuNome.setEditable(true);
				TelaPerfil.textUsuCpf.setEditable(true);
				TelaPerfil.textUsuLogin.setEditable(true);
				TelaPerfil.textUsuSenha.setEditable(true);
			}
		});
		btnAtualizar.setBounds(10, 203, 89, 23);
		contentPane.add(btnAtualizar);
	}
}
