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

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaCompras extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
	private JScrollPane scrollPane;
	private Connection conexao = null;
	private JTable table2;
	
	public TelaCompras() {
		
		conexao = ConexaoMySQL.conector();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(430, 220, 539, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 503, 154);
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
		
		JLabel lblNewLabel = new JLabel("Pacotes Disponiveis");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(170, 11, 182, 23);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 210, 503, 36);
		contentPane.add(scrollPane2);
		
		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		
		//table.getSelectedRows();
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				table.getSelectedRows();
				table.getSelectedColumns();
/*				try {
					String query = "select * from tbpct_viagem";
					PreparedStatement pst=conexao.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					
				}*/
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
		
		
	
	}
}
