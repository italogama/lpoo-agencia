package br.com.agencia.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.agencia.conexaoBanco.ConexaoMySQL;
import br.com.agencia.model.Usuario;
import br.com.agencia.negocio.LoginRN;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private boolean isAdmin;
	private LoginRN loginRN;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void logarConfirmado(Usuario usuario) {
		
	
				if (usuario.getPerfil().equals("admin")) {
					TelaPrincipal principal = new TelaPrincipal();
					principal.setVisible(true);
					TelaPrincipal.mnCadastro.setEnabled(true);
					TelaPrincipal.mntmCliente_1.setEnabled(true);
					TelaPrincipal.lblLogado.setText(usuario.getNome());
					TelaPrincipal.lblLogado.setForeground(Color.red);
					this.dispose();
				}else {
					TelaPrincipal principal = new TelaPrincipal();
					principal.setVisible(true);
					TelaPrincipal.lblLogado.setText(usuario.getNome());
					TelaPrincipal.lblLogado.setForeground(Color.blue);
					this.dispose();
				}

	}

	public TelaLogin() {
		usuario = new Usuario();
		loginRN = new LoginRN();
		setTitle(".: \u00C1rea de Acesso :.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(480, 190, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setForeground(UIManager.getColor("Button.background"));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 10, 414, 242);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNovoAquiClique = new JLabel("Novo aqui? Clique aqui para se cadastrar!");
		lblNovoAquiClique.setForeground(Color.BLACK);
		lblNovoAquiClique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaUsuario tela3 = new TelaUsuario(false);
				tela3.setVisible(true);
			}
		});

		JLabel lblStatus_1 = new JLabel("Status:");
		lblStatus_1.setBounds(10, 217, 46, 14);
		panel.add(lblStatus_1);

		JLabel lblStatus = new JLabel("");
		lblStatus.setBounds(51, 211, 122, 31);
		panel.add(lblStatus);
		lblNovoAquiClique.setBounds(173, 222, 241, 14);
		panel.add(lblNovoAquiClique);

		/*Campo de Usuario*/
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					usuario.setLogin(txtUsuario.getText());
					try {
					logarConfirmado(loginRN.doLogin(usuario));
					}catch(Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				} else {
					if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						System.exit(0);
					}
				}
			}
		});
		txtUsuario.setBounds(191, 60, 86, 20);
		txtUsuario.setColumns(10);
		panel.add(txtUsuario);

		JLabel label_1 = new JLabel("Senha:");
		label_1.setBounds(133, 90, 51, 25);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(label_1);

		JLabel label = new JLabel("Usu\u00E1rio:");
		label.setBounds(124, 55, 74, 25);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(label);

		/* BOTÃO DE LOGIN */
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usuario.setLogin(txtUsuario.getText());
				usuario.setSenha(txtSenha.getText() );
				// Coletando as informações digitadas
				
				try {
					// Entrando na regra de negocio "doLogin"
					// Usuario logado = loginRN.doLogin(usuario);
					logarConfirmado(loginRN.doLogin(usuario));
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLogin.setBounds(133, 126, 74, 23);
		panel.add(btnLogin);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(217, 126, 74, 23);
		panel.add(btnNewButton);

		
		/* CAMPO DE SENHA */
		
		txtSenha = new JPasswordField();
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					usuario.setLogin(txtUsuario.getText());
					usuario.setSenha(txtSenha.getText());
					
					try {
						logarConfirmado(loginRN.doLogin(usuario));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				} else {
					if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						System.exit(0);
					}
				}
			}
		});
		txtSenha.setBounds(191, 94, 85, 20);
		panel.add(txtSenha);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\backlogin2.png"));
		lblNewLabel.setBounds(0, 0, 414, 242);
		panel.add(lblNewLabel);
		
		/* Criação de Thread para verificar status do server*/
		Thread t = new Thread(new StatusServer(lblStatus));
		t.start();
	}
}
