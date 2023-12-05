package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.OuvinteAdicionarMaterial;
import DAO.MaterialDAO;
import DTO.MaterialDTO;
import Model.TipoDeMaterial;

public class JanelaAdicionarMateriais extends JanelaPadrao {

	public static void main(String[] args) {
		new JanelaAdicionarMateriais();
	}

	private JTextField campoDeNome;
	private JList<TipoDeMaterial> campoDeMaterial;
	private JRadioButton radioButton;
	private JTextField valor;
	private JTextField quantidade;

	public JRadioButton getRadioButton() {
		return radioButton;
	}

	public void setRadioButton(JRadioButton radioButton) {
		this.radioButton = radioButton;
	}

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
		addTexto(125, 270, 130, 20, "Disponível:");
//		addTexto(125, 320, 130, 20, "Quantidade:");
//		addTexto(280, 320, 130, 20, "Preço por tam:");
		campoDeNome = addCampoDeTexto(125, 135, 300, 25, new LineBorder(Color.BLACK, 1), "Digite o nome do material");
		adicionarCampoDeMateriais();
//		valor = addCampoDeTexto(280, 340, 145, 25, new LineBorder(Color.BLACK, 1), "Digite o preço");
		radioButton = new JRadioButton();
		radioButton.setBounds(220, 270, 20, 20);
		radioButton.setOpaque(false);
		radioButton.setForeground(Color.WHITE);
		add(radioButton);
//		quantidade = addCampoDeTexto(125, 340, 145, 25, new LineBorder(Color.BLACK, 1), "Digite a quantidade");
		addBotao(220, 400, 110, 30, "Confirmar", new OuvinteAdicionarMaterial(this));
		addBotaoDeVoltar();

		setVisible(true);
	}

	public JanelaAdicionarMateriais(MaterialDTO material) {
		addTexto(0, 30, 550, 30, "Editar Material", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(125, 110, 65, 20, "Nome:");
		addTexto(125, 160, 140, 20, "Tipo:");
		addTexto(125, 270, 130, 20, "Disponível:");
		radioButton = new JRadioButton();
		radioButton.setBounds(220, 270, 20, 20);
		radioButton.setOpaque(false);
		radioButton.setForeground(Color.WHITE);
		radioButton.setSelected(material.isDisponivel());
		;
		add(radioButton);

		campoDeNome = addCampoDeTexto(125, 135, 300, 25, new LineBorder(Color.BLACK, 1), material.getNome());
		adicionarCampoDeMateriais();

		addBotao(220, 400, 110, 30, "Editar", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String nome = campoDeNome.getText();
				List<TipoDeMaterial> tipoDeMateriais = campoDeMaterial.getSelectedValuesList();
				boolean disponibilidade = ((radioButton.isSelected()) ? true : false);

				if (tipoDeMateriais.size() > 1 || tipoDeMateriais.size() < 1) {
					JOptionPane.showMessageDialog(null, "Escolha apenas um tipo de material");
				} else {
					material.setDisponivel(disponibilidade);
					material.setNome(nome);
					material.setTipoDeMaterial(tipoDeMateriais.get(0));
					
					MaterialDAO gerenciador = new MaterialDAO();

					gerenciador.atualizarMaterial(material);

					JOptionPane.showMessageDialog(null, "Editado");

					new JanelaAdicionarMateriais();
					dispose();
				}
			}

		});
		addBotaoDeVoltar(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaListaMateriais();
			}

		});

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
