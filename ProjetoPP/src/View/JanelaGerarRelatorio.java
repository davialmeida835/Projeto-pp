package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import Model.GeradorDeRelatorio;
import Model.Util;

public class JanelaGerarRelatorio extends JanelaPadrao{

	
	private JCheckBox tabelaDeDespesas;
	private JCheckBox tabelaDeVendas;
	private JCheckBox lucro;
	
	private JCheckBox clientesNovos;
	
	private File[] files;
	
	public File[] getFiles() {
		return files;
	}

	
	
	public void setFiles(File[] files) {
		this.files = files;
	}
	
	public JCheckBox getTabelaDeDespesas() {
		return tabelaDeDespesas;
	}

	public JCheckBox getTabelaDeVendas() {
		return tabelaDeVendas;
	}

	public JCheckBox getLucros() {
		return lucro;
	}

	

	public JCheckBox getClientesNovos() {
		return clientesNovos;
	}

	
	
	public JanelaGerarRelatorio() {
		
		tabelaDeDespesas = addCheckBox(85, 130, 140, 30, "Tabela de despesas");
		tabelaDeVendas = addCheckBox(85, 160, 140, 30, "Tabela de vendas");
		lucro = addCheckBox(85, 190, 140, 30, "Lucro");
		clientesNovos = addCheckBox(85, 220, 140, 30, "Clientes novos");
		
		
		addBotao(210, 400, 130, 35, "Gerar PDF", new GeradorDeRelatorio(this)); 
		addBotao(325, 100, 140, 30, "Escolher fotos", new GeradorDeRelatorio(this));
		addTexto(0, 10, 550, 40, "Gerar pdf do mês", Util.FONTE_PADRAO, JLabel.CENTER,
				Color.WHITE);
		addBotao(85, 100, 140, 30, "Selecione tudo", new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				tabelaDeDespesas.setSelected(true);
				tabelaDeVendas.setSelected(true);
				lucro.setSelected(true);
				clientesNovos.setSelected(true);
				
				
			}
		});
		addBotaoDeVoltar();
		setVisible(true);
	}
	
	public JCheckBox addCheckBox(int x, int y, int largura, int altura, String titulo) {
		JCheckBox box = new JCheckBox(titulo);
		box.setBounds(x, y, largura, altura);
		box.setForeground(Color.WHITE);
		box.setOpaque(false);
		add(box);
		return box;	
	}
	
	
	public static void main(String[] args) {
		new JanelaGerarRelatorio();
	}
}
