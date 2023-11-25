package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.Persistencia;
import Model.CentralDeInformacoes;
import Model.Material;

public class JanelaListaClientes extends JanelaPadrao{

	private JTable tabela;
	
	public JTable getTabela() {
		return tabela;
	}
	
	public JanelaListaClientes() {
		addTexto(0, 30, 550, 30, "Lista de Clientes", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);		

		adicionarTabela();
		addBotaoDeVoltar();
		addBotao(220, 90, 110, 30, "Excluir", null);
		addWallpaper();
		setVisible(true);
	}
	
	private void adicionarTabela() {
		CentralDeInformacoes central = Persistencia.recuperarCentral("central");
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nome");
		model.addColumn("CPF/CNPJ");
		model.addColumn("Tamanho do material");
		model.addColumn("Disponibilidade");
		
		for(Material m : central.getMateriais()) {
			Object[] itens = new Object[4];
			itens[0] = m.getNome();
			itens[1] = m.getTipoDeMaterial();
			itens[2] = m.getTamanho(); 
			itens[3] = (m.isDisponivel()) ? "Disponível" : "Não está Disponível";
			
			model.addRow(itens);
		}
		
		tabela = new JTable(model);

		JScrollPane barraRolagem = new JScrollPane(tabela);

		barraRolagem.setBounds(25, 150, 490, 250);

		add(barraRolagem);

	}
}
