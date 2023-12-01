package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.MaterialDAO;
import DTO.MaterialDTO;
import Model.CentralDeInformacoes;
import Model.Material;
import Model.TipoDeMaterial;
import View.JanelaAdicionarMateriais;

public class OuvinteAdicionarMaterial implements ActionListener{

	private JanelaAdicionarMateriais janela;
	
	public OuvinteAdicionarMaterial(JanelaAdicionarMateriais janela) {
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent e) {

		
		String nome = janela.getCampoDeNome().getText();
		List<TipoDeMaterial> tipoDeMateriais = janela.getCampoDeMaterial().getSelectedValuesList();
//		double valor = Double.parseDouble(janela.getValor().getText());
		double tamanho = Double.parseDouble(janela.getTamanho().getText());
//		double quantidade = Double.parseDouble(janela.getQuantidade().getText());
		
		if(tipoDeMateriais.size() > 1) {
			JOptionPane.showMessageDialog(janela, "Escolha apenas um tipo");
		}
		
		 MaterialDTO material = new MaterialDTO(nome, tamanho, tipoDeMateriais.get(0));
		 
		 MaterialDAO gerenciador = new MaterialDAO();
		 
		 gerenciador.cadastrarMaterial(material);
		 
		 JOptionPane.showMessageDialog(janela, "Adicionado");
		 
		 new JanelaAdicionarMateriais();
		 janela.dispose();
	}

	
}

