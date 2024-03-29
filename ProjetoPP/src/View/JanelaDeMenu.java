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
		addBotoesMenu(65, 55, 200, 40, "CADASTRAR CLIENTES", (getClass().getResource("/resources/clientenovo.png")));
		addBotoesMenu(275, 55, 200, 40, "CADASTRAR MATERIAIS", getClass().getResource("/resources/material.png"));
		addBotoesMenu(65, 110, 200, 40, "CADASTRAR FORNECEDORES", getClass().getResource("/resources/fornecedor23.png"));
		addBotoesMenu(275, 110, 200, 40, "CADASTRAR PEDIDOS", getClass().getResource("/resources/pedido.png"));
		addBotoesMenu(65, 165, 200, 40, "LISTA DE PEDIDOS", getClass().getResource("/resources/lista23.png"));
		addBotoesMenu(275, 165, 200, 40, "LISTA DE FORNECEDORES", getClass().getResource("/resources/lista23.png"));
		addBotoesMenu(65, 220, 200, 40, "LISTA DE MATERIAIS", getClass().getResource("/resources/lista23.png"));
		addBotoesMenu(275, 220, 200, 40, "LISTA DE CLIENTES", getClass().getResource("/resources/lista23.png"));
		addBotoesMenu(65, 275, 200, 40, "VERIFICAR AGENDA", getClass().getResource("/resources/agenda23.png"));
		addBotoesMenu(275, 275, 200, 40, "GERAR RELATÓRIO", getClass().getResource("/resources/relatorio.png"));

		addBotoesMenu(65, 330, 200, 40, "CADASTRAR DATA", getClass().getResource("/resources/calendario23.png"));
		addBotoesMenu(275, 330, 200, 40, "LISTA DE DATAS", getClass().getResource("/resources/lista23.png"));

		

		addBotoesMenu(65, 385, 200, 40, "HISTÓRICO DE COMPRAS", getClass().getResource("/resources/historico23.png"));
		addBotoesMenu(275, 385, 200, 40, "PERFIL DO USUÁRIO", getClass().getResource("/resources/usuarioicon.png"));


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