package Model;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractTable {
	
	public DefaultTableModel addColunas(String[] colunas) {
		DefaultTableModel model = new DefaultTableModel();
		
		for(int i = 0; i < colunas.length; i++) {
			model.addColumn(colunas[i]);
		}
		
		return model;
	}
	
	public abstract JTable addDados(JTable tabela, DefaultTableModel model);
	
	public void gerenciarScrollPane(JTable tabela, JFrame frame) {
		JScrollPane barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(25, 150, 490, 250);
		frame.add(barraRolagem);
	}
	
	public void gancho() {};
	
	public JTable criarTabela(String[] colunas, JTable tabela, DefaultTableModel model, JFrame frame) {
		model = addColunas(colunas);
		tabela = addDados(tabela, model);
		gerenciarScrollPane(tabela, frame);
		gancho();
		return tabela;
	}
	
}
