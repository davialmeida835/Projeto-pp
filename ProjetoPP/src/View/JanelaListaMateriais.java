package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				
				if(i != -1) {
					MaterialDAO gerenciar = new MaterialDAO();
					gerenciar.deletarMaterial(CentralDeInformacoes.getInstance().getMateriais().get(i));
					
					
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
				
					tamanho = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho(m): "));
					
					HistoricoDeCompraDTO historico = new HistoricoDeCompraDTO(CentralDeInformacoes.getInstance().getMateriais().get(i), preco, tamanho);
					HistoricoDeCompraDAO dao = new HistoricoDeCompraDAO();
					dao.cadastrarHistoricoDeCompra(historico);
					
					MaterialDAO material = new MaterialDAO();
					material.atualizarMaterial(CentralDeInformacoes.getInstance().getMateriais().get(i), tamanho);
					
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
				
			}
			
		});
		addBotao(400, 95, 100, 30, "Filtrar", new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				filtrarFornecedores();
			}
		});
		campoFiltro = addCampoDeTexto(50, 95, 325, 30);
		setVisible(true);
	}
	
	private void filtrarFornecedores() {
   	 	String nomeFiltro = campoFiltro.getText().trim().toLowerCase();

   	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tabela.getModel());
   	    tabela.setRowSorter(sorter);

   	    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + nomeFiltro, 0); // O índice 0 refere-se à coluna do nome
   	    sorter.setRowFilter(rowFilter);
   	
   	    
   }
	
	private void adicionarTabela() {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		
		model = new DefaultTableModel();
		model.addColumn("Nome do material");
		model.addColumn("Tipo do material");
		model.addColumn("Tamanho do material");
		
		for(MaterialDTO m : central.getMateriais()) {
			Object[] itens = new Object[3];
			itens[0] = m.getNome();
			itens[1] = m.getTipoDeMaterial();
			itens[2] = m.getTamanho(); 
			
			model.addRow(itens);
		}
		
		tabela = new JTable(model);

		JScrollPane barraRolagem = new JScrollPane(tabela);

		barraRolagem.setBounds(25, 150, 490, 250);

		add(barraRolagem);

	}
}
