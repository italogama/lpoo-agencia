package br.com.agencia.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {

	public JPanel contentPanePrincipal;
	public static JMenu mnCadastro;
	static JMenuItem mntmCliente_1;
	static JLabel lblLogado;

	public TelaPrincipal() {
		
		setTitle(".: RIEL Ag\u00EAncia de Viagens 1.0 :.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 160, 729, 484);
		setSize(600, 440);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		mntmCliente_1 = new JMenuItem("Usuario");
		mntmCliente_1.setEnabled(false);
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// as linhas abaixo abrem o form Tela Cliente dentro da tela principal
				TelaUsuario cliente = new TelaUsuario(true);
				cliente.setVisible(true);
				TelaUsuario.btnUsuRead.setEnabled(true);
				TelaUsuario.btnUsuDelete.setEnabled(true);
				TelaUsuario.btnUsuUpdate.setEnabled(true);
				TelaUsuario.cboUsuPerfil.setEnabled(true);
			}
		});
		mnCadastro.add(mntmCliente_1);
		
		JMenu mnComprarPacote = new JMenu("Comprar Pacote");
		menuBar.add(mnComprarPacote);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pacotes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCompras tela4 = new TelaCompras();
				tela4.setVisible(true);
			}
		});
		mnComprarPacote.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Hoteis Disponiveis");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaHotel telahotel = new TelaHotel();
				telahotel.setVisible(true);
			}
		});
		mnComprarPacote.add(mntmNewMenuItem_1);
					
					JMenu mnSobre = new JMenu("Ajuda");
					menuBar.add(mnSobre);
					
					JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sobre");
					mntmNewMenuItem_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							JOptionPane.showMessageDialog(null, "Sistema desenvolvido para uma Agência de Viagens\n"
									+ "Feito por: Robson, Italo, Erick, Leandro.");
						}
					});
					mnSobre.add(mntmNewMenuItem_2);
					
					JMenu mnPerfil = new JMenu("Perfil");
					mnPerfil.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							TelaPerfil telaperfil = new TelaPerfil();
							telaperfil.setVisible(true);
						}
					});
					menuBar.add(mnPerfil);
					
					JMenu menu = new JMenu("\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0");
					menu.setEnabled(false);
					menuBar.add(menu);
					
						
						JMenu mnConfiguraes = new JMenu("Sair");
						mnConfiguraes.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								//exibe uma caixa de dialogo pra saida do programa
								int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que gostaria de sair?","Atenção",JOptionPane.YES_NO_OPTION);
								if (sair == JOptionPane.YES_OPTION) {
									TelaLogin login = new TelaLogin();
									login.setVisible(true);
									dispose();
								}
							}
						});
						menuBar.add(mnConfiguraes);
		contentPanePrincipal = new JPanel();
		contentPanePrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanePrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPanePrincipal);
		
		JPanel panel = new JPanel();
		contentPanePrincipal.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblLogado = new JLabel("");
		lblLogado.setBounds(485, 0, 115, 14);
		panel.add(lblLogado);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(346, 25, 210, 14);
		panel.add(lblData);
		
		JLabel lblLogadoComo = new JLabel("Voc\u00EA est\u00E1 logado como:");
		lblLogadoComo.setBounds(346, 0, 145, 14);
		panel.add(lblLogadoComo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setEnabled(true);
		lblNewLabel_1.setIcon(new ImageIcon("img\\back.png"));
		lblNewLabel_1.setBounds(0, 0, 584, 380);
		panel.add(lblNewLabel_1);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//inserir/formatar data na label
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblData.setText(formatador.format(data));
			}
		});
	}
	protected JMenu getMnCadastro() {
		return mnCadastro;
	}
	protected JMenuItem getMntmCliente() {
		return mntmCliente_1;
	}
	public JLabel getLblLogado() {
		return lblLogado;
	}
}
