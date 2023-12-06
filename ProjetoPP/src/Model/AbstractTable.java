package Model;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractTable {

	
	public abstract void addColunas(DefaultTableModel model);
	
	public abstract void addDados(JTable tabela, DefaultTableModel model);
	
	public void definirTamanhoDaTabela(JTable tabela, JScrollPane barraRolagem) {
		
	}
	
	
	public void addTabelaAoFrame(JFrame jframe, JTable jtable) {
		jframe.add(jtable);
	}
	
	public void criarTabela(JTable tabela, DefaultTableModel model, JScrollPane barraRolagem, JFrame frame) {
		
		definirTamanhoDaTabela(tabela, barraRolagem);
		addColunas(model);
		addDados(tabela, model);
		addTabelaAoFrame(frame, tabela);
	}
	
}
