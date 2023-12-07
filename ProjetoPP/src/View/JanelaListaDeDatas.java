package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.DatasDeNotificacaoController;
import DTO.DatasDeNotificacaoDTO;

import Model.CentralDeInformacoes;

public class JanelaListaDeDatas extends JanelaPadrao{
	private JTextField campoFiltro;
	private JTable tabelaDatas; 
	private DefaultTableModel modeloTabela;
	private List<DatasDeNotificacaoDTO> listaDeDatas;
	
	
	public JanelaListaDeDatas() {
		addTexto(0, 30, 550, 30, "Lista de Datas ", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(0, 60, 550, 30, "para Notificar Clientes ", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addBotaoDeVoltar();
		listaDeDatas = new ArrayList<>();
		configurarTabela();
		adicionarDadosATabela();
		adicionarBotoesAtualizarExcluir();
		setVisible(true);
	}
	public static void main(String [] args) {
		JanelaListaDeDatas j =  new JanelaListaDeDatas();
	}
	private void configurarTabela() {
		modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Data de Entrega");
        modeloTabela.addColumn("Descricão");
        
        
        listaDeDatas= CentralDeInformacoes.getInstance().getDatas();

        tabelaDatas = new JTable(modeloTabela); 
        JScrollPane scrollPane = new JScrollPane(tabelaDatas); 
        scrollPane.setBounds(50, 170, 450, 200);
        add(scrollPane);
        
        campoFiltro = new JTextField();
        campoFiltro.setBounds(50, 115, 325, 30);
        add(campoFiltro);
        
        JButton botaoFiltrar = new JButton("Filtrar");
        botaoFiltrar.setBounds(400, 115, 100, 30);
        botaoFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String criterio = campoFiltro.getText();
                filtrarPedidos(criterio);
            }
        });
        add(botaoFiltrar);
	}
	private void adicionarDadosATabela() {
		if (listaDeDatas != null) {
		for (DatasDeNotificacaoDTO data : listaDeDatas) {
	        modeloTabela.addRow(new Object[] {data.getId(),data.getDataDeEntrega(),data.getDescricao()});
	    }
		}
	}
	 private void filtrarPedidos(String criterio) {
		    
		 modeloTabela.setRowCount(0);

		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		    for (DatasDeNotificacaoDTO data : listaDeDatas) {
		        // Converte a String do critério para LocalDate
		        LocalDate criterioDate = LocalDate.parse(criterio, formatter);

		        // Compara as datas
		        if (data.getDataDeEntrega().equals(criterioDate)) {
		            modeloTabela.addRow(new Object[]{data.getId(), data.getDataDeEntrega(), data.getDescricao()});
		        }
		    }
	  }

	  private void adicionarBotoesAtualizarExcluir() {
	        JButton botaoAtualizar = addBotao(150, 400, 100, 30, "Atualizar", new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int linhaSelecionada = tabelaDatas.getSelectedRow();
	                if (linhaSelecionada != -1) {
	                    DatasDeNotificacaoDTO dataSelecionada = listaDeDatas.get(linhaSelecionada);

	                    // Exemplo de lógica de atualização
	                    String novaDescricao = JOptionPane.showInputDialog("Digite a nova descrição:");
	                    dataSelecionada.setDescricao(novaDescricao);
	                    
	                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	                    String dataAtualFormatada = dataSelecionada.getDataDeEntrega().format(formatter);
	                    String novaDataString = JOptionPane.showInputDialog("Digite a nova data (dd/MM/yyyy):", dataAtualFormatada);

	                    try {
	                        LocalDate novaData = LocalDate.parse(novaDataString, formatter);
	                        dataSelecionada.setDataDeEntrega(novaData);
	                    } catch (DateTimeParseException ex) {
	                        JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
	                    }
	                   
	                    DatasDeNotificacaoController d = new DatasDeNotificacaoController(dataSelecionada);
                        d.atualizar();
                        atualizarTabela();
                      

	                   
	                } else {
	                    JOptionPane.showMessageDialog(null, "Selecione uma data para atualizar.");
	                }
	            }
	        });

	        JButton botaoExcluir = addBotao(300, 400, 100, 30, "Excluir", new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int linhaSelecionada = tabelaDatas.getSelectedRow();
	                if (linhaSelecionada != -1) {
	                    int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
	                    if (confirmacao == JOptionPane.YES_OPTION) {
	                        DatasDeNotificacaoDTO dataSelecionada = listaDeDatas.get(linhaSelecionada);
	                        DatasDeNotificacaoController d = new DatasDeNotificacaoController(dataSelecionada);
	                        d.remover();
	                        atualizarTabela();
	                      
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Selecione uma data para excluir.");
	                }
	            }
	        });
	    }
	  private void atualizarTabela() {
		    modeloTabela.setRowCount(0);
		    adicionarDadosATabela();
		}

}
