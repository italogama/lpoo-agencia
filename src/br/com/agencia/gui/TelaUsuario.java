package br.com.agencia.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.agencia.model.Sessao;
import br.com.agencia.model.Usuario;
import br.com.agencia.negocio.LoginRN;
import br.com.agencia.negocio.RegraUsuario;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuLogin;
	private JTextField txtUsuNome;
	private JPasswordField txtUsuSenha;
	private JTextField txtUsuCpf;
	private JTextField txtUsuId;
	private boolean isLogado = false;
	static JButton btnUsuRead;
	static JButton btnUsuUpdate;
	static JButton btnUsuDelete;
	static JComboBox cboUsuPerfil;
	private LoginRN loginRN;
	private RegraUsuario regraUsuario;

	public TelaUsuario(boolean logado) {

		regraUsuario = new RegraUsuario();
		this.isLogado = logado;
		loginRN = new LoginRN();

		setTitle(".: Cadastro Usu\u00E1rio :.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(480, 230, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("* LoginRN:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(10, 63, 56, 17);
		contentPane.add(lblLogin);

		txtUsuLogin = new JTextField();
		txtUsuLogin.setColumns(10);
		txtUsuLogin.setBounds(67, 63, 130, 20);
		contentPane.add(txtUsuLogin);

		JLabel lblSenha = new JLabel("* Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(207, 64, 62, 14);
		contentPane.add(lblSenha);

		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 89, 56, 14);
		contentPane.add(lblNome);

		txtUsuNome = new JTextField();
		txtUsuNome.setColumns(10);
		txtUsuNome.setBounds(67, 88, 357, 20);
		contentPane.add(txtUsuNome);

		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(20, 115, 34, 14);
		contentPane.add(lblCpf);

		JButton btnUsuCreate = new JButton("");

		btnUsuCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Usuario usuario = new Usuario();

				usuario.setLogin(txtUsuLogin.getText());
				usuario.setSenha(txtUsuSenha.getText());
				usuario.setNome(txtUsuNome.getText());
				usuario.setCpf(txtUsuCpf.getText());
				usuario.setPerfil(cboUsuPerfil.getSelectedItem());

				int adicionado = 0;

				try {
					adicionado = regraUsuario.adicionarOrAlterar(usuario);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!!");
					txtUsuNome.setText(null);
					txtUsuLogin.setText(null);
					txtUsuCpf.setText(null);
					txtUsuSenha.setText(null);
					cboUsuPerfil.setSelectedItem(null);
					if (!isLogado) {
						dispose();
					}
				}

				
			}
		});

		btnUsuCreate.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnUsuCreate.setToolTipText("Adicionar");
		btnUsuCreate.setIcon(new ImageIcon("img\\insert.png"));
		btnUsuCreate.setBounds(20, 170, 80, 80);
		contentPane.add(btnUsuCreate);

		cboUsuPerfil = new JComboBox();
		cboUsuPerfil.setEnabled(false);
		cboUsuPerfil.setModel(new DefaultComboBoxModel(new String[] { " ", "user", "admin" }));
		cboUsuPerfil.setSelectedIndex(1);
		cboUsuPerfil.setBounds(67, 139, 102, 20);
		contentPane.add(cboUsuPerfil);

		JLabel lblPerfil = new JLabel("* Perfil:");
		lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPerfil.setBounds(10, 140, 56, 14);
		contentPane.add(lblPerfil);

		txtUsuSenha = new JPasswordField();
		txtUsuSenha.setBounds(265, 63, 130, 20);
		contentPane.add(txtUsuSenha);

		txtUsuCpf = new JTextField();
		txtUsuCpf.setColumns(10);
		txtUsuCpf.setBounds(67, 114, 130, 20);
		contentPane.add(txtUsuCpf);

		btnUsuRead = new JButton("");
		btnUsuRead.setEnabled(false);
		btnUsuRead.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Usuario usuario = regraUsuario.consultaUsuario(txtUsuId.getText());
				
				if (usuario == null) {
					JOptionPane.showMessageDialog(null, "Usuario não encontrado!");
					return;
				}
					
				txtUsuNome.setText(usuario.getNome());
				txtUsuLogin.setText(usuario.getLogin());
				txtUsuCpf.setText(usuario.getCpf());
				txtUsuSenha.setText(usuario.getSenha());
				cboUsuPerfil.setSelectedItem(usuario.getPerfil());
			}
		});
		btnUsuRead.setToolTipText("Consultar");
		btnUsuRead.setIcon(new ImageIcon("img\\read.png"));
		btnUsuRead.setBounds(124, 170, 80, 80);
		contentPane.add(btnUsuRead);

		btnUsuUpdate = new JButton("");
		btnUsuUpdate.setEnabled(false);
		btnUsuUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Usuario usuario = new Usuario();
				usuario.setId(txtUsuId.getText());
				usuario.setLogin(txtUsuLogin.getText());
				usuario.setSenha(txtUsuSenha.getText());
				usuario.setNome(txtUsuNome.getText());
				usuario.setCpf(txtUsuCpf.getText());
				usuario.setPerfil(cboUsuPerfil.getSelectedItem().toString());
				int adicionado = 0;
				try {
					adicionado = regraUsuario.adicionarOrAlterar(usuario);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso!!");
					txtUsuNome.setText(null);
					txtUsuLogin.setText(null);
					txtUsuCpf.setText(null);
					txtUsuSenha.setText(null);
					cboUsuPerfil.setSelectedItem(null);
				}

			}

		});
		btnUsuUpdate.setToolTipText("Atualizar");
		btnUsuUpdate.setIcon(new ImageIcon("img\\update.png"));
		btnUsuUpdate.setBounds(230, 170, 80, 80);
		contentPane.add(btnUsuUpdate);

		btnUsuDelete = new JButton("");
		btnUsuDelete.setEnabled(false);
		btnUsuDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int apagado = regraUsuario.remover(txtUsuId.getText());
				if (apagado > 0) {
					JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
					txtUsuId.setText(null);
					txtUsuNome.setText(null);
					txtUsuLogin.setText(null);
					txtUsuCpf.setText(null);
					txtUsuSenha.setText(null);
					cboUsuPerfil.setSelectedItem(null);
				} else {
					JOptionPane.showConfirmDialog(null, "Usuário não encontrado!");
				}
			}
		});
		btnUsuDelete.setToolTipText("Deletar");
		btnUsuDelete.setIcon(new ImageIcon("img\\delete.png"));
		btnUsuDelete.setBounds(329, 170, 80, 80);
		contentPane.add(btnUsuDelete);

		JLabel lblCampoConsulta = new JLabel("Consulta por ID:");
		lblCampoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCampoConsulta.setBounds(20, 11, 130, 17);
		contentPane.add(lblCampoConsulta);

		txtUsuId = new JTextField();
		txtUsuId.setColumns(10);
		txtUsuId.setBounds(124, 11, 34, 20);
		contentPane.add(txtUsuId);
		txtUsuId.setEnabled(logado);

		JLabel lblCadastro = new JLabel("CADASTRO");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastro.setBounds(179, 39, 90, 17);
		contentPane.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("* Campos Obrigat\u00F3rios");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(254, 119, 130, 14);
		contentPane.add(lblNewLabel);
		
		if(Sessao.usuarioLogado != null) {
			txtUsuId.setEnabled(true);
			if (Sessao.usuarioLogado.getPerfil().equals("user")) {
				txtUsuId.setEnabled(false);
			}
			txtUsuId.setText(Sessao.usuarioLogado.getId());
			Usuario usuario = regraUsuario.consultaUsuario(Sessao.usuarioLogado.getId());
			
			if (usuario == null) {
				return;
			}
				
			txtUsuNome.setText(usuario.getNome());
			txtUsuLogin.setText(usuario.getLogin());
			txtUsuCpf.setText(usuario.getCpf());
			txtUsuSenha.setText(usuario.getSenha());
			cboUsuPerfil.setSelectedItem(usuario.getPerfil());
			
		}
			
		
	}

	public JButton getBtnUsuRead() {
		return btnUsuRead;
	}

	public JButton getBtnUsuUpdate() {
		return btnUsuUpdate;
	}

	public JButton getBtnUsuDelete() {
		return btnUsuDelete;
	}
}
