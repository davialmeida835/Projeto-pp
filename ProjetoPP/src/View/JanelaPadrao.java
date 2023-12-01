package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Controller.OuvinteDoBotaoDeVoltarParaMenu;
import Controller.OuvinteTirarTextoDeTextField;
import Model.Util;

public class JanelaPadrao extends JFrame{
	
	
	public JanelaPadrao() {
		Color corAzulEscuro = Color.decode("#FAD4A5");
		getContentPane().setBackground(corAzulEscuro);
		setResizable(false);
		setTitle("Gerenciador de Confecções");
		setSize(550, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
	}
	
	public void addWallpaper() {
		ImageIcon ii = new ImageIcon(getClass().getResource("/resources/wallpaper3.png"));
		JLabel label = new JLabel(ii);
		
		label.setBounds(0,0, 550,500);
		add(label);
	}
	
	//botão de voltar padrão para o menu
	public void addBotaoDeVoltar() {
		OuvinteDoBotaoDeVoltarParaMenu o = new OuvinteDoBotaoDeVoltarParaMenu(this);
		ImageIcon ii = new ImageIcon(getClass().getResource("/resources/voltar.png"));
		JButton bmenu = new JButton(ii);
		bmenu.addActionListener(o);
		bmenu.setBackground(Color.BLACK);
		bmenu.setOpaque(false);
		bmenu.setBounds(40, 20, 33, 25);
		add(bmenu);
	}
	
	//botão de voltar com um action listener
	public void addBotaoDeVoltar(ActionListener ouvinte) { 
		ImageIcon imagem = new ImageIcon(getClass().getResource("/resources/voltar.png"));
		JButton botao = new JButton(imagem);
		botao.setBackground(Color.BLACK);
		botao.setOpaque(false);
		botao.setBounds(40, 20, 33, 25);
		botao.addActionListener(ouvinte); 
		add(botao);
	}
	
	//adiciona um texto comum
	public void addTexto(int x, int y, int largura, int altura, String texto) {
        JLabel label = new JLabel(texto);
        label.setBounds(x, y, largura, altura);
        label.setFont(Util.FONTE_PADRAO);
        label.setForeground(Color.BLACK);
        add(label);
    }
	
	//adiciona um texto com mais opções
	public void addTexto(int x, int y, int largura, int altura, String texto, Font fonte, int alinhamento, Color cor) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, largura, altura);
		label.setFont(fonte);
		label.setHorizontalAlignment(alinhamento);
		label.setForeground(cor);
		add(label);
	}
		
	//adiciona um campo de texto comum
	public JTextField addCampoDeTexto(int x, int y, int largura, int altura,LineBorder borda) {
		JTextField campoDeTexto = new JTextField();
		campoDeTexto.setFont(Util.FONTE_PADRAO);
		campoDeTexto.setBorder(borda);
		campoDeTexto.setBounds(x, y, largura, altura);
		add(campoDeTexto);
		return campoDeTexto;
	}
	
	//adiciona um campo de texto formatado
	public JTextField addCampoDeTextoFormatado(int x, int y, int largura, int altura,LineBorder borda, String formato) {
		try {
			MaskFormatter formatador = new MaskFormatter(formato);
			JTextField campoDeTexto = new JFormattedTextField(formatador);
			campoDeTexto.setFont(Util.FONTE_PADRAO);
			campoDeTexto.setBorder(borda);
			campoDeTexto.setBounds(x, y, largura, altura);
			add(campoDeTexto);
			return campoDeTexto;
			
		} catch (Exception e) {
			return null;
		}
	}
	public void addComboBox(int x, int y, int largura, int altura, String[] opcoes) {
		JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(x, y, largura, altura);
        add(comboBox);
	}
	
	//adiciona um campo de texto normal com o focus listener
	public JTextField addCampoDeTexto(int x, int y, int largura, int altura,LineBorder borda, String texto) {
		JTextField campoDeTexto = new JTextField(texto);
		
		campoDeTexto.setFont(Util.FONTE_PADRAO);
		campoDeTexto.addFocusListener(new OuvinteTirarTextoDeTextField(campoDeTexto.getText()));
		campoDeTexto.setBorder(borda);
		campoDeTexto.setBounds(x, y, largura, altura);
		add(campoDeTexto);
		return campoDeTexto;
	}
	
	//adiciona botão já com action listener
	public JButton addBotao(int x, int y, int largura, int altura, String titulo, ActionListener ouvinte) {
		JButton botao = new JButton(titulo);
		botao.setBounds(x, y, largura, altura);
		botao.setForeground(Color.BLACK);
		botao.setBackground(Color.WHITE);
		botao.addActionListener(ouvinte);
		add(botao);
		return botao;
		
	}
	
	//adiciona as imagens a tela de cadastro e login
	public void addIconeTelaCadastroELogin() {
		ImageIcon imagemDoUsuario = new ImageIcon(getClass().getResource("/resources/preto.png"));
		JLabel imagem = new JLabel(imagemDoUsuario);
		imagem.setBounds(243, 75, 75, 80);
		add(imagem);
		
		
	}
	
}