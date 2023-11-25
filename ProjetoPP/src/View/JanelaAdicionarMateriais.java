package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.Persistencia;
import Model.CentralDeInformacoes;
import Model.Material;
import Model.TipoDeMaterial;

public class JanelaAdicionarMateriais extends JanelaPadrao{

	public static void main(String[] args) {
		new JanelaAdicionarMateriais();
	}
	
	private JTextField campoDeNome;
	private JList<TipoDeMaterial> campoDeMaterial;
	private JTextField campoDeValor;
	private JTextField campoDePublicoAlvo;
	
	
	
	public JanelaAdicionarMateriais() {
		addTexto(0, 30, 550, 30, "Adicionar Material", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);		
		addTexto(125, 110, 65, 20, "Nome:");
		addTexto(125, 160, 140, 20, "Tipo:");
		addTexto(125, 270, 80, 20, "Tamanho:");
		addTexto(125, 320, 130, 20, "Quantidade:");
		campoDeNome = addCampoDeTexto(125, 135, 300, 25, new LineBorder(Color.BLACK, 1), "Digite o nome do material");
		adicionarCampoDeMateriais();
		campoDePublicoAlvo = addCampoDeTexto(125, 340, 300, 25, new LineBorder(Color.BLACK, 1), "Digite a quantidade");
		campoDeValor = addCampoDeTexto(125, 290, 300, 25, new LineBorder(Color.BLACK, 1), "Digite o tamanho do material(m)");
		addBotao(220, 400, 110, 30, "Confirmar", null);
		addBotaoDeVoltar();
		addWallpaper();
		setVisible(true);
	}
	
	private void adicionarCampoDeMateriais() {
		DefaultListModel<TipoDeMaterial> dlm = new DefaultListModel<>();
		
		CentralDeInformacoes cdi = Persistencia.recuperarCentral("central");
		
		for(TipoDeMaterial t : cdi.getTipoDeMateriais()) {
			dlm.addElement(t);
		}
		
		campoDeMaterial = new JList<>(dlm);
		JScrollPane jsp = new JScrollPane(campoDeMaterial);
		jsp.setBorder(new LineBorder(Color.BLACK, 1));
		jsp.setFont(new Font("Arial", Font.PLAIN, 19));
		jsp.setBounds(125, 180, 300, 80);
		add(jsp);
	}
}