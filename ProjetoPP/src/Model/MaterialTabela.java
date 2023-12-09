package Model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.ClienteDTO;
import DTO.MaterialDTO;

public class MaterialTabela extends AbstractTable{

	
	public JTable addDados(JTable tabela, DefaultTableModel model) {
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
		return tabela;
	}
	
}
