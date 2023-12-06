package Model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.ClienteDTO;

public class ClienteTabela extends AbstractTable{

	public JTable addDados(JTable tabela, DefaultTableModel model) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		
		for(ClienteDTO m : central.getClientes()) {
			Object[] itens = new Object[4];
			itens[0] = m.getNome();
			itens[1] = m.getTelefone();
			itens[2] = m.getEmail();
			itens[3] = m.getCpfECnpj();
			model.addRow(itens);
		}
		
		tabela = new JTable(model);
		return tabela;
	}
}