package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.HistoricoDeCompraDAO;
import DTO.HistoricoDeCompraDTO;
import Model.CentralDeInformacoes;
import Model.TabelaCompraDeMaterial;

public class JanelaListaCompraDeMateriais extends JanelaPadrao {

	private JTable tabela;
	private JTextField campoFiltro;
	private DefaultTableModel model;

	public static void main(String[] args) {
		new JanelaListaCompraDeMateriais();
	}
	
	public JanelaListaCompraDeMateriais() {
		addTexto(0, 30, 550, 30, "Histórico de compras de Materiais", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);		

		adicionarTabela();
		addBotaoDeVoltar();
		addBotao(220, 420, 110, 30, "Excluir", new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int i = tabela.getSelectedRow();
				
				if(i != -1) {
					HistoricoDeCompraDAO gerenciar = new HistoricoDeCompraDAO();
					gerenciar.deletarHistoricoDeCompra(CentralDeInformacoes.getInstance().getHistorico().get(i));
					JOptionPane.showMessageDialog(null, "Apagado com sucesso");
					dispose();
					new JanelaListaCompraDeMateriais();
				}
			}
		});
		
		addTexto(50, 95, 150, 30, "Gastos desse mês: ");
		
		double preco = 0;
		for (HistoricoDeCompraDTO m : CentralDeInformacoes.getInstance().getHistorico()) {
			if(m.getDataDaCompra().getMonth() == LocalDate.now().getMonth()) {
				preco += m.getPreco();
			}
		}
		
		addTexto(210, 95, 150, 30, String.valueOf(preco));
		
		setVisible(true);
	}
	
	private void adicionarTabela() {
		TabelaCompraDeMaterial tabelaFeita = new TabelaCompraDeMaterial();
		
		String[] dados = {"Nome do material", "Preço", "Data"};

		tabela = tabelaFeita.criarTabela(dados, tabela, model, this);

	}
	
	
}
