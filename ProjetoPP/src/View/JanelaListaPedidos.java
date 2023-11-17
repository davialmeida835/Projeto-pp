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
		
		setVisible(true);
		
		listaDePedidos = new ArrayList<>();
        listaDePedidos.add(new Pedido(1, "Pedido 1 - Descrição", "2023-12-01", "Item 1, Item 2"));
        listaDePedidos.add(new Pedido(2, "Pedido 2 - Descrição", "2023-12-05", "Item 3, Item 4"));
        listaDePedidos.add(new Pedido(3, "Pedido 3 - Descrição", "2023-12-10", "Item 5, Item 6"));

        adicionarBotoesAtualizarExcluir();
        configurarTabela();
        adicionarDadosATabela();
        repaint();
	}
	private void configurarTabela() {
		modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Número do Pedido");
        modeloTabela.addColumn("Descrição");
        modeloTabela.addColumn("Data de Entrega");
        modeloTabela.addColumn("Itens");

        tabelaPedidos = new JTable(modeloTabela); 
        JScrollPane scrollPane = new JScrollPane(tabelaPedidos); 
        scrollPane.setBounds(50, 90, 450, 200);
        add(scrollPane);
        
        campoFiltro = new JTextField();
        campoFiltro.setBounds(50, 370, 200, 25);
        add(campoFiltro);


       
        JButton botaoFiltrar = new JButton("Filtrar");
        botaoFiltrar.setBounds(270, 370, 100, 25);
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
	        modeloTabela.addRow(new Object[]{pedido.getNumero(), pedido.getDescricao(), pedido.getDataEntrega(), pedido.getItens()});
	    }
	}
	  private void adicionarBotoesAtualizarExcluir() {
		  JButton botaoAtualizar = addBotao(50, 310, 100, 30, "Atualizar", new ActionListener() {
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

			JButton botaoExcluir = addBotao(200, 310, 100, 30, "Excluir", new ActionListener() {
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
		        if (pedido.getDescricao().contains(criterio) || pedido.getDataEntrega().contains(criterio) || pedido.getItens().contains(criterio)) {
		            modeloTabela.addRow(new Object[]{pedido.getNumero(), pedido.getDescricao(), pedido.getDataEntrega(), pedido.getItens()});
		        }
		    }
	  }
	  public static void main(String[]args) {
		  JanelaListaPedidos j = new JanelaListaPedidos();
	  }
}
