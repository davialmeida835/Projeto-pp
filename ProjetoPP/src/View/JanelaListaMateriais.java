package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Persistencia;
import Model.CentralDeInformacoes;
import Model.Material;

public class JanelaListaMateriais extends JanelaPadrao{

	public static void main(String[] args) {
		new JanelaListaMateriais();
	}
	
	private JTable tabela;
	
	public JTable getTabela() {
		return tabela;
	}
	
	public JanelaListaMateriais() {
		addTexto(0, 30, 550, 30, "Lista de Materiais", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);		

		adicionarTabela();
		addBotaoDeVoltar();
		addBotao(220, 90, 110, 30, "Excluir", null);
		
		
		addWallpaper();
		setVisible(true);
	}
	
	private void adicionarTabela() {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nome do material");
		model.addColumn("Tipo do material");
		model.addColumn("Tamanho do material");
		
		for(Material m : central.getMateriais()) {
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
