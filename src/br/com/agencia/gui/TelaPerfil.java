package br.com.agencia.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.agencia.model.Sessao;
import br.com.agencia.model.Usuario;
import br.com.agencia.negocio.RegraUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPerfil extends JFrame {

	public JPanel contentPane;
	public static JTextField txtUsuNome;
	public static JTextField txtUsuCpf;
	public static JTextField txtUsuLogin;
	public static JTextField txtUsuSenha;
	private RegraUsuario regraUsuario;
	static JComboBox cboUsuPerfil;
	
	public TelaPerfil() {
		
		regraUsuario = new RegraUsuario();
		
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
		
		txtUsuNome = new JTextField();
		txtUsuNome.setEditable(false);
		txtUsuNome.setBounds(61, 62, 164, 20);
		contentPane.add(txtUsuNome);
		txtUsuNome.setColumns(10);
		
		txtUsuCpf = new JTextField();
		txtUsuCpf.setEditable(false);
		txtUsuCpf.setBounds(60, 91, 165, 20);
		contentPane.add(txtUsuCpf);
		txtUsuCpf.setColumns(10);
		
		txtUsuLogin = new JTextField();
		txtUsuLogin.setEditable(false);
		txtUsuLogin.setBounds(61, 123, 164, 20);
		contentPane.add(txtUsuLogin);
		txtUsuLogin.setColumns(10);
		
		txtUsuSenha = new JTextField();
		txtUsuSenha.setEditable(false);
		txtUsuSenha.setBounds(61, 154, 164, 20);
		contentPane.add(txtUsuSenha);
		txtUsuSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {

				Usuario usuario = new Usuario();
				
				usuario.setId(Sessao.usuarioLogado.getId());
				usuario.setLogin(txtUsuLogin.getText());
				usuario.setSenha(txtUsuSenha.getText());
				usuario.setNome(txtUsuNome.getText());
				usuario.setCpf(txtUsuCpf.getText());
				usuario.setPerfil(Sessao.usuarioLogado.getPerfil());
				int adicionado = 0;
				try {
					adicionado = regraUsuario.adicionarOrAlterar(usuario);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso!!");
				}

			}

		});
		btnSalvar.setBounds(226, 203, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(325, 203, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPerfil.txtUsuNome.setEditable(true);
				TelaPerfil.txtUsuCpf.setEditable(true);
				TelaPerfil.txtUsuLogin.setEditable(true);
				TelaPerfil.txtUsuSenha.setEditable(true);
			}
		});
		btnAtualizar.setBounds(10, 203, 89, 23);
		contentPane.add(btnAtualizar);
		
		if(Sessao.usuarioLogado != null) {
			Usuario usuario = regraUsuario.consultaUsuario(Sessao.usuarioLogado.getId());
			
			if (usuario == null) {
				return;
			}
				
			txtUsuNome.setText(usuario.getNome());
			txtUsuLogin.setText(usuario.getLogin());
			txtUsuCpf.setText(usuario.getCpf());
			txtUsuSenha.setText(usuario.getSenha());
			
		}
			
	}
	
}
