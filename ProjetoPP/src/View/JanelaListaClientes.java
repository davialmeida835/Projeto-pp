package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import Model.CentralDeInformacoes;

public class JanelaListaClientes extends JanelaPadrao{

	private JTable tabela;
	private JTextField campoFiltro;
	private DefaultTableModel model;
	
	public JTable getTabela() {
		return tabela;
	}
	
	public JanelaListaClientes() {
		addTexto(0, 30, 550, 30, "Lista de Clientes", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);		

		adicionarTabela();
		addBotaoDeVoltar();
		addBotao(80, 420, 110, 30, "Excluir", new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int i = tabela.getSelectedRow();
				
				if(i != -1) {
					ClienteDAO gerenciar = new ClienteDAO();
					gerenciar.deletarCliente(CentralDeInformacoes.getInstance().getClientes().get(i));
					
				}
				dispose();
				new JanelaListaClientes();
			}
		});
		
		addBotao(360, 420, 110, 30, "Editar", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int i = tabela.getSelectedRow();
				new JanelaAdicionarMateriais(CentralDeInformacoes.getInstance().getMateriais().get(i));
				dispose();
			}
			
		});
		addBotao(400, 95, 100, 30, "Filtrar", new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				filtrarClientes();
			}
		});
		
		campoFiltro = addCampoDeTexto(50, 95, 325, 30);
		setVisible(true);
	}
	
	private void adicionarTabela() {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		
		model = new DefaultTableModel();
		model.addColumn("Nome");
		model.addColumn("Telefone");
		model.addColumn("E-mail");
		model.addColumn("Identificador");
		
		for(ClienteDTO m : central.getClientes()) {
			Object[] itens = new Object[4];
			itens[0] = m.getNome();
			itens[1] = m.getTelefone();
			itens[2] = m.getEmail();
			itens[2] = m.getCpfECnpj();
			model.addRow(itens);
		}
		
		tabela = new JTable(model);

		JScrollPane barraRolagem = new JScrollPane(tabela);

		barraRolagem.setBounds(25, 150, 490, 250);

		add(barraRolagem);

	}
	
	private void filtrarClientes() {
   	 	String nomeFiltro = campoFiltro.getText().trim().toLowerCase();

   	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tabela.getModel());
   	    tabela.setRowSorter(sorter);

   	    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + nomeFiltro, 0); // O índice 0 refere-se à coluna do nome
   	    sorter.setRowFilter(rowFilter);
   	
   	    
   }
	public static void main(String []args) {
		JanelaListaClientes j = new JanelaListaClientes();
	}
}
