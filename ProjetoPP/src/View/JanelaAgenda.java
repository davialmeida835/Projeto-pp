package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.PedidoDTO;
import Model.AbstractTable;
import Model.CentralDeInformacoes;

public class JanelaAgenda extends JanelaPadrao {

	private JTable tabelaPedidos;
	private JComboBox comboEscolha;
	private DefaultTableModel tableModel;

	public JComboBox getComboEscolha() {
		return comboEscolha;
	}

	public JTable getTabelaPedidos() {
		return tabelaPedidos;
	}

	public JanelaAgenda() {
		addTexto(0, 25, 550, 30, "Verificar Agenda", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
//	        addTexto(0, 30, 550, 30, "Verificar Agenda", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);

		String[] opcoes = { "Dia", "Semana", "Mês" };
		comboEscolha = new JComboBox<>(opcoes);
		comboEscolha.setBounds(200, 90, 150, 30);
		add(comboEscolha);
		

		String[] colunas = { "Número do Pedido", "Cliente", "Produto", "Quantidade", "Data" };
		
		tableModel = new DefaultTableModel();
		
		for(int i = 0; i < colunas.length; i++) {
			tableModel.addColumn(colunas[i]);
		}
		
		for (PedidoDTO m : CentralDeInformacoes.getInstance().getPedidos()) {
			if (m.getDataEntrega().equals(LocalDate.now())) {
				Object[] itens = new Object[5];
				itens[0] = m.getNumero();
				itens[1] = m.getCliente().getNome();
				itens[2] = m.getTipoderoupa();
				itens[3] = m.getQuantidade();
				itens[4] = m.getDataEntrega();
				tableModel.addRow(itens);
			}
		}
		
		tabelaPedidos = new JTable(tableModel);
		
		JScrollPane barraRolagem = new JScrollPane(tabelaPedidos);
		barraRolagem.setBounds(25, 150, 490, 250);
		add(barraRolagem);
		
		comboEscolha.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);

				CentralDeInformacoes central = CentralDeInformacoes.getInstance();
				if (getComboEscolha().getSelectedItem().equals("Dia")) {
					for (PedidoDTO m : central.getPedidos()) {
						if (m.getDataEntrega().equals(LocalDate.now())) {
							Object[] itens = new Object[5];
							itens[0] = m.getNumero();
							itens[1] = m.getCliente().getNome();
							itens[2] = m.getTipoderoupa();
							itens[3] = m.getQuantidade();
							itens[4] = m.getDataEntrega();
							tableModel.addRow(itens);
						}
					}
				} else if (getComboEscolha().getSelectedItem().equals("Semana")) {
					int semanaAtual = LocalDate.now().get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
					for (PedidoDTO m : central.getPedidos()) {
						if (semanaAtual == m.getDataEntrega()
								.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear())) {
							Object[] itens = new Object[5];
							itens[0] = m.getNumero();
							itens[1] = m.getCliente().getNome();
							itens[2] = m.getTipoderoupa();
							itens[3] = m.getQuantidade();
							itens[4] = m.getDataEntrega();
							tableModel.addRow(itens);
						}
					}
				} else {
					for (PedidoDTO m : central.getPedidos()) {
						if (LocalDate.now().getMonth() == m.getDataEntrega().getMonth()
								&& LocalDate.now().getYear() == m.getDataEntrega().getYear()) {
							Object[] itens = new Object[5];
							itens[0] = m.getNumero();
							itens[1] = m.getCliente().getNome();
							itens[2] = m.getTipoderoupa();
							itens[3] = m.getQuantidade();
							itens[4] = m.getDataEntrega();
							tableModel.addRow(itens);
						}
					}
				}
				
			}

		});

		

		addBotaoDeVoltar();
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		JanelaAgenda j = new JanelaAgenda();
	}
}
