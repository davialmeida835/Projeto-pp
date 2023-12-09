package Model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.HistoricoDeCompraDTO;

public class TabelaCompraDeMaterial extends AbstractTable {

	public JTable addDados(JTable tabela, DefaultTableModel model) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();

		model = new DefaultTableModel();
		model.addColumn("Nome do material");
		model.addColumn("Preço");
		model.addColumn("Data");

		
		
		for (HistoricoDeCompraDTO m : central.getHistorico()) {
			Object[] itens = new Object[3];
			itens[0] = m.getMaterial().getNome();
			itens[1] = m.getPreco();
			itens[2] = (m.getDataDaCompra());

			model.addRow(itens);
		}
		
		tabela = new JTable(model);
		return tabela;
	}

}
