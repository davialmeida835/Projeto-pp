package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DAO.HistoricoDeCompraDAO;
import DAO.MaterialDAO;
import DTO.HistoricoDeCompraDTO;
import DTO.MaterialDTO;
import Model.CentralDeInformacoes;
import Model.MaterialTabela;

public class JanelaListaMateriais extends JanelaPadrao{

	public static void main(String[] args) {
		new JanelaListaMateriais();
	}
	
	private JTable tabela;
	private JTextField campoFiltro;
	private DefaultTableModel model;
	
	public JTable getTabela() {
		return tabela;
	}
	
	public JanelaListaMateriais() {
		addTexto(0, 30, 550, 30, "Lista de Materiais", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);		

		adicionarTabela();
		addBotaoDeVoltar();
		addBotao(220, 420, 110, 30, "Excluir", new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int i = tabela.getSelectedRow();
				int modeloIndex = tabela.convertRowIndexToModel(i);
				
				if(i != -1) {
					MaterialDAO gerenciar = new MaterialDAO();
					gerenciar.deletarMaterial(CentralDeInformacoes.getInstance().getMateriais().get(modeloIndex));
					JOptionPane.showMessageDialog(null, "Material apagado com sucesso!");
					model.setRowCount(0);
					for(MaterialDTO m : CentralDeInformacoes.getInstance().getMateriais()) {
						Object[] itens = new Object[3];
						itens[0] = m.getNome();
						itens[1] = m.getTipoDeMaterial();
						itens[2] = (m.isDisponivel()) ? "Disponível" : "Indisponível"; 
						
						model.addRow(itens);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Escolha um material antes!");
				}
				
				
			}
		});
		addBotao(80, 420, 110, 30, "Comprar", new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				int i = tabela.getSelectedRow();
				double preco;
				double tamanho;
				try{
					preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço: "));
					
					HistoricoDeCompraDTO historico = new HistoricoDeCompraDTO(CentralDeInformacoes.getInstance().getMateriais().get(i), preco);
					HistoricoDeCompraDAO dao = new HistoricoDeCompraDAO();
					dao.cadastrarHistoricoDeCompra(historico);
					
					MaterialDAO material = new MaterialDAO();
					material.atualizarMaterial(CentralDeInformacoes.getInstance().getMateriais().get(i), true);
					
					JOptionPane.showMessageDialog(null, "Adicionado no histórico com sucesso");
					new JanelaListaMateriais();
					dispose();
				}catch(Exception exception) {
					JOptionPane.showMessageDialog(null, "Digite valores válidos");
				}
			}
			
		});
		addBotao(360, 420, 110, 30, "Editar", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(tabela.getSelectedRow() != -1) {
				int i = tabela.getSelectedRow();
				new JanelaAdicionarMateriais(CentralDeInformacoes.getInstance().getMateriais().get(i));
				dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Escolha um material antes!");
				}
			}
			
		});
		addBotao(400, 95, 100, 30, "Filtrar", new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				filtrarMateriais();
			}
		});
		addBotao(400, 45, 100, 30, "Histórico", new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new JanelaListaCompraDeMateriais();
				dispose();
			}
		});
		campoFiltro = addCampoDeTexto(50, 95, 325, 30);
		setVisible(true);
	}
	
	private void filtrarMateriais() {
   	 	String nomeFiltro = campoFiltro.getText().trim().toLowerCase();

   	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tabela.getModel());
   	    tabela.setRowSorter(sorter);

   	    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + nomeFiltro, 0); // O índice 0 refere-se à coluna do nome
   	    sorter.setRowFilter(rowFilter);
   	    
   	    
   	  
   	
   	    
   }
	//comitt
	private void adicionarTabela() {
//		MaterialTabela tabelaFeita = new MaterialTabela();
		
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		
		model = new DefaultTableModel();
		model.addColumn("Nome do material");
		model.addColumn("Tipo do material");
		model.addColumn("Disponibilidade do material");
		
		for(MaterialDTO m : central.getMateriais()) {
			Object[] itens = new Object[3];
			itens[0] = m.getNome();
			itens[1] = m.getTipoDeMaterial();
			itens[2] = (m.isDisponivel()) ? "Disponível" : "Indisponível"; 
			
			model.addRow(itens);
		}
		
		tabela = new JTable(model);
//		return tabela;		
//		tabela = tabelaFeita.criarTabela(dados, tabela, model, this);
		JScrollPane barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(25, 150, 490, 250);
		add(barraRolagem);
	}
}
