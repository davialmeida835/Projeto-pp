package Model;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractTable {

	public abstract void addColunas(DefaultTableModel model);
	
	public abstract void addDados(JTable tabela, DefaultTableModel model);
	
	public abstract void definirTamanhoDaTabela(JTable tabela, JScrollPane barraRolagem);
	
	public void criarTabela(JTable tabela, DefaultTableModel model, JScrollPane barraRolagem) {
		addColunas(model);
		addDados(tabela, model);
		definirTamanhoDaTabela(tabela, barraRolagem);
	}
	
}
