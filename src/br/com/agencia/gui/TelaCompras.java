package br.com.agencia.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import br.com.agencia.conexaoBanco.ConexaoMySQL;
import br.com.agencia.model.Compra;
import br.com.agencia.model.Sessao;
import br.com.agencia.negocio.RegraCompra;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class TelaCompras extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
	private JScrollPane scrollPane;
	private Connection conexao = null;
	private RegraCompra regraCompra = null;
	
	public TelaCompras() {
		setTitle(".: Compras :.");
		
		regraCompra = new RegraCompra();
		conexao = ConexaoMySQL.conector();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(430, 220, 539, 353);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 503, 139);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String query = "select v.pct_id  " + 
				"	,v.pct_nome  " + 
				"	,v.pct_destino  " + 
				"	,v.pct_valor  " + 
				"	,v.pct_diaria_incluida  " + 
				"	,h.hotel_nome   " + 
				"from tbpct_viagem v inner join tbhotel h ON v.pct_hotel = h.hotel_id;";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("ID");
			table.getColumnModel().getColumn(0).setPreferredWidth(15);
			table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Nome do Pacote");
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Destino");
			table.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Valor");
			table.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("Diaria Inclusa");
			table.getTableHeader().getColumnModel().getColumn(5).setHeaderValue("Hotel");
			repaint();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//table.getSelectedRows();
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				String Table_click = (table.getModel().getValueAt(row, 1).toString());
				int idPacote = (int) table.getModel().getValueAt(row, 0);
				double valor = Double.parseDouble( table.getModel().getValueAt(row, 3).toString() );
				Compra novaCompra = new Compra();
				novaCompra.setIdUsuario( Integer.parseInt(Sessao.usuarioLogado.getId()) );
				novaCompra.setIdPacote(idPacote);
				novaCompra.setValor(valor);
				int qtdInserido = regraCompra.cadastrar(novaCompra);
				if (qtdInserido > 0) {
					JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!!");
					TelaPrincipal.atualizaCompras(regraCompra.retornarUltimasCompras(Sessao.usuarioLogado.getId()), TelaPrincipal.table);
					dispose();
				}else{
					//erro
				}
			}
		});
		btnConfirmar.setBounds(296, 280, 99, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(405, 280, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("img\\telacompras.png"));
		lblNewLabel_1.setBounds(0, 0, 533, 324);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
}
