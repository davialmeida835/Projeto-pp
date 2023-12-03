package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.OuvinteBotoesMenu;

public class JanelaDeMenu extends JanelaPadrao {
	
	public static void main(String[] args) {
		new JanelaDeMenu();
	}
	
	public JanelaDeMenu() {
		addTexto(0, 20, 550, 30, "Menu", new Font("Arial", Font.BOLD, 18), JLabel.CENTER, Color.BLACK);
		addBotoesMenu(125, 55, 300, 40, "CADASTRAR CLIENTES", (getClass().getResource("/resources/Cliente.png")));
		addBotoesMenu(125, 100, 300, 40, "CADASTRAR MATERIAIS", getClass().getResource("/resources/Fornecedor.png"));
		addBotoesMenu(125, 235, 300, 40, "", getClass().getResource("/resources/Pacote.png"));
		addBotoesMenu(125, 145, 300, 40, "CADASTRAR FORNECEDORES", getClass().getResource("/resources/Servicos.png"));
		addBotoesMenu(125, 190, 300, 40, "", getClass().getResource("/resources/Servicos.png"));
		addBotoesMenu(125, 280, 300, 40, "LISTA DE FORNECEDORES", getClass().getResource("/resources/Orcamento.png"));
		addBotoesMenu(125, 325, 300, 40, "LISTA DE MATERIAIS", getClass().getResource("/resources/Lista.png"));
		addBotoesMenu(125, 370, 300, 40, "GERENCIAR TIPOS DE MATERIAIS", getClass().getResource("/resources/Lista.png"));
		addBotoesMenu(125, 415, 300, 40, "", getClass().getResource("/resources/Lista.png"));
		
		addBotaoDeVoltar(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Você quer sair?", "Sair da conta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					new JanelaDeLogin();
					dispose();
				}	
			}
		});	
		addWallpaper();
		setVisible(true);
	}
	
	public void addBotoesMenu(int x, int y, int largura, int altura, String texto, URL url) {
		OuvinteBotoesMenu ouvinte = new OuvinteBotoesMenu(this);
		JButton botao = new JButton(texto);
		botao.addActionListener(ouvinte);
		botao.setBackground(Color.WHITE);
//		botao.setOpaque(false);
		botao.setForeground(Color.BLACK);
		botao.setBounds(x, y, largura, altura);
		botao.setIcon(new ImageIcon(url));
		add(botao);
	}
	
	private void addBordas() {
		ImageIcon bordaEsquerda = new ImageIcon(getClass().getResource("/resources/ladoEsquerdo.jpeg"));
		JLabel lado1 = new JLabel(bordaEsquerda);
		lado1.setBounds(0, 0, 70, 500);
		add(lado1);
		ImageIcon bordaDireita = new ImageIcon(getClass().getResource("/resources/ladoDireito.jpeg"));
		JLabel lado2 = new JLabel(bordaDireita);
		lado2.setBounds(475, 0, 70, 500);
		add(lado2);
	}

}