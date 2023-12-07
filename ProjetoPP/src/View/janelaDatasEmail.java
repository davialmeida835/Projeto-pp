package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Controller.DatasDeNotificacaoController;
import DTO.DatasDeNotificacaoDTO;
import Model.Util;

public class janelaDatasEmail extends JanelaPadrao {
	private JTextArea textoParaCliente;
	private JFormattedTextField campoDaData;
	public janelaDatasEmail() {
		addTexto(0, 30, 550, 30, "Adicionar Datas ", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(0, 60, 550, 30, "para Notificar Clientes ", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(180,150,200,30,"Data para enviar o email:");
		addBotaoDeVoltar();
		addTexto(180,210,200,30,"Texto  para o Cliente:");
		adicionarCampoDaDataDeEntrega();
		adicionarCampoTextoCliente(); 
		addB();
		setVisible(true);
	}
	 private void adicionarCampoTextoCliente() {
	        textoParaCliente = new JTextArea();
	        textoParaCliente.setFont(Util.FONTE_PADRAO);
	        textoParaCliente.setLineWrap(true);
	        JScrollPane scrollPane = new JScrollPane(textoParaCliente);
	        scrollPane.setBounds(180, 240, 190, 100);
	        add(scrollPane);
	    }
	 private void addB() {
			JButton botao = new JButton("Cadastrar");
			botao.setBounds(225, 400, 100, 30);
			botao.setForeground(Color.BLACK);
			botao.setBackground(Color.WHITE);
			botao.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	 cadastrarDados();	
		            
		               
		            }
		        });
			
			add(botao);
		
		
		}
	private void adicionarCampoDaDataDeEntrega() {
		
		
		try {
			MaskFormatter mf = new MaskFormatter("##/##/####");
			campoDaData = new JFormattedTextField(mf);
			campoDaData.setBorder(new LineBorder(Color.BLACK, 1));
			campoDaData.setFont(Util.FONTE_PADRAO);
			campoDaData.setHorizontalAlignment(JTextField.CENTER);
			campoDaData.setBounds(180, 180, 190, 25);
			add(campoDaData);
		} catch (ParseException e) {}

	}
	private void cadastrarDados() {
        String dataString = campoDaData.getText();
        String descricao = textoParaCliente.getText();

        // Verifica se os campos estão preenchidos
        if (dataString.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            return;
        }

        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // Cria uma instância de DatasDeNotificacaoDTO com os valores obtidos
        DatasDeNotificacaoDTO dados = new DatasDeNotificacaoDTO(data, descricao);
        DatasDeNotificacaoController d = new DatasDeNotificacaoController(dados);
        d.add();
        
	}

	public static void main(String [] args) {
		janelaDatasEmail j = new janelaDatasEmail();
	}
}
