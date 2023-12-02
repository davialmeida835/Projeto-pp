package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Model.Pedido;

public class JanelaListaPedidos extends JanelaPadrao{
	private JTextField campoFiltro;
	private JTable tabelaPedidos; 
	private List<Pedido> listaDePedidos;
    private DefaultTableModel modeloTabela;
	public JanelaListaPedidos() {
		addTexto(0, 10, 550, 30, "Lista de Pedidos", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		
		
		addTexto(50,65,350,30,"Filtrar pedido por data e por itens:");
		
        addBotaoDeVoltar();
        adicionarBotoesAtualizarExcluir();
        configurarTabela();
        adicionarDadosATabela();
        repaint();
        setVisible(true);
	}
	private void configurarTabela() {
		modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Número do Pedido");
        modeloTabela.addColumn("Descrição");
        modeloTabela.addColumn("Data de Entrega");
        modeloTabela.addColumn("Itens");

        tabelaPedidos = new JTable(modeloTabela); 
        JScrollPane scrollPane = new JScrollPane(tabelaPedidos); 
        scrollPane.setBounds(50, 150, 450, 200);
        add(scrollPane);
        
        campoFiltro = new JTextField();
        campoFiltro.setBounds(50, 95, 325, 30);
        add(campoFiltro);


       
        JButton botaoFiltrar = new JButton("Filtrar");
        botaoFiltrar.setBounds(400, 95, 100, 30);
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
	    for (Pedido pedido : listaDePedidos) {
	        modeloTabela.addRow(new Object[]{pedido.getNumero(), pedido.getDescricao(), pedido.getDataEntrega()});
	    }
	}
	  private void adicionarBotoesAtualizarExcluir() {
		  JButton botaoAtualizar = addBotao(150, 400, 100, 30, "Atualizar", new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        
			        int linhaSelecionada = tabelaPedidos.getSelectedRow(); 
			        if (linhaSelecionada != -1) {
			            
			            int numeroPedido = (int) modeloTabela.getValueAt(linhaSelecionada, 0);
			            String descricaoPedido = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
			            String dataEntregaPedido = (String) modeloTabela.getValueAt(linhaSelecionada, 2);
			            String itensPedido = (String) modeloTabela.getValueAt(linhaSelecionada, 3);

			           
			            String novaDescricao = JOptionPane.showInputDialog("Digite a nova descrição para o pedido " + numeroPedido, descricaoPedido);
			            String novaDataEntrega = JOptionPane.showInputDialog("Digite a nova data de entrega para o pedido " + numeroPedido, dataEntregaPedido);
			            String novosItens = JOptionPane.showInputDialog("Digite os novos itens para o pedido " + numeroPedido, itensPedido);

			            
			            modeloTabela.setValueAt(novaDescricao, linhaSelecionada, 1);
			            modeloTabela.setValueAt(novaDataEntrega, linhaSelecionada, 2);
			            modeloTabela.setValueAt(novosItens, linhaSelecionada, 3);
			        } else {
			            JOptionPane.showMessageDialog(null, "Selecione um pedido para atualizar.");
			        }
			    }
			});

			JButton botaoExcluir = addBotao(300, 400, 100, 30, "Excluir", new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        
			        int linhaSelecionada = tabelaPedidos.getSelectedRow();
			        if (linhaSelecionada != -1) {
			            modeloTabela.removeRow(linhaSelecionada);
			        } else {
			            JOptionPane.showMessageDialog(null, "Selecione um pedido para excluir.");
			        }
			    }
			});
	  }
	  private void filtrarPedidos(String criterio) {
		    
		    modeloTabela.setRowCount(0);

		   
		    for (Pedido pedido : listaDePedidos) {
		        if (pedido.getDescricao().contains(criterio)  ) {
		            modeloTabela.addRow(new Object[]{pedido.getNumero(), pedido.getDescricao(), pedido.getDataEntrega()});
		        }
		    }
	  }
	  public static void main(String[]args) {
		  JanelaListaPedidos j = new JanelaListaPedidos();
	  }
}
