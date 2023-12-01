package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.OuvinteAdicionarMaterial;
import Model.TipoDeMaterial;

public class JanelaAdicionarMateriais extends JanelaPadrao{

	public static void main(String[] args) {
		new JanelaAdicionarMateriais();
	}
	
	private JTextField campoDeNome;
	private JList<TipoDeMaterial> campoDeMaterial;
	private JTextField tamanho;
	private JTextField valor;
	private JTextField quantidade;

	public JTextField getCampoDeNome() {
		return campoDeNome;
	}

	public void setCampoDeNome(JTextField campoDeNome) {
		this.campoDeNome = campoDeNome;
	}

	public JList<TipoDeMaterial> getCampoDeMaterial() {
		return campoDeMaterial;
	}

	public void setCampoDeMaterial(JList<TipoDeMaterial> campoDeMaterial) {
		this.campoDeMaterial = campoDeMaterial;
	}

	public JTextField getTamanho() {
		return tamanho;
	}

	public void setTamanho(JTextField tamanho) {
		this.tamanho = tamanho;
	}

	public JTextField getValor() {
		return valor;
	}

	public void setValor(JTextField valor) {
		this.valor = valor;
	}

	public JTextField getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(JTextField quantidade) {
		this.quantidade = quantidade;
	}

	public JanelaAdicionarMateriais() {
		addTexto(0, 30, 550, 30, "Adicionar Material", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);		
		addTexto(125, 110, 65, 20, "Nome:");
		addTexto(125, 160, 140, 20, "Tipo:");
		addTexto(125, 270, 80, 20, "Tamanho:");
//		addTexto(125, 320, 130, 20, "Quantidade:");
//		addTexto(280, 320, 130, 20, "Preço por tam:");
		campoDeNome = addCampoDeTexto(125, 135, 300, 25, new LineBorder(Color.BLACK, 1), "Digite o nome do material");
		adicionarCampoDeMateriais();
//		valor = addCampoDeTexto(280, 340, 145, 25, new LineBorder(Color.BLACK, 1), "Digite o preço");

//		quantidade = addCampoDeTexto(125, 340, 145, 25, new LineBorder(Color.BLACK, 1), "Digite a quantidade");
		tamanho = addCampoDeTexto(125, 290, 300, 25, new LineBorder(Color.BLACK, 1), "Digite o tamanho do material(m)");
		addBotao(220, 400, 110, 30, "Confirmar", new OuvinteAdicionarMaterial(this));
		addBotaoDeVoltar();
		addWallpaper();
		setVisible(true);
	}
	
	private void adicionarCampoDeMateriais() {
		DefaultListModel<TipoDeMaterial> dlm = new DefaultListModel<>();
		
		dlm.addElement(TipoDeMaterial.TECIDO);
		dlm.addElement(TipoDeMaterial.LINHA);
		dlm.addElement(TipoDeMaterial.FERRAMENTA);
		dlm.addElement(TipoDeMaterial.OUTROS);
		
		campoDeMaterial = new JList<>(dlm);
		JScrollPane jsp = new JScrollPane(campoDeMaterial);
		jsp.setBorder(new LineBorder(Color.BLACK, 1));
		jsp.setFont(new Font("Arial", Font.PLAIN, 19));
		jsp.setBounds(125, 180, 300, 80);
		add(jsp);
	}
}
