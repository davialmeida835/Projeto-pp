package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import Controller.PedidoController;
import DTO.PedidoDTO;
import Model.CentralDeInformacoes;
import Model.Pedido;

public class JanelaListaPedidos extends JanelaPadrao{
	private JTextField campoFiltro;
	private JTable tabelaPedidos; 
	private List<PedidoDTO> listaDePedidos;
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
        modeloTabela.addColumn("Preço");
        modeloTabela.addColumn("Data de Entrega");
        modeloTabela.addColumn("Pagamento");
        
        listaDePedidos= CentralDeInformacoes.getInstance().getPedidos();

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
	    for (PedidoDTO pedido : listaDePedidos) {
	        modeloTabela.addRow(new Object[]{pedido.getNumero(), pedido.getPreco(), pedido.getDataEntrega(),pedido.isPagamento()});
	    }
	}
	  private void adicionarBotoesAtualizarExcluir() {
		  JButton botaoAtualizar = addBotao(150, 400, 100, 30, "Atualizar", new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        
			        int linhaSelecionada = tabelaPedidos.getSelectedRow(); 
			        if (linhaSelecionada != -1) {
			            
			        	int numeroPedido = (int) modeloTabela.getValueAt(linhaSelecionada, 0);

		                // Encontrar o pedido correspondente na lista
		                PedidoDTO pedidoSelecionado = null;
		                for (PedidoDTO pedido : listaDePedidos) {
		                    if (pedido.getNumero() == numeroPedido) {
		                        pedidoSelecionado = pedido;
		                        break;
		                    }
		                }

		                if (pedidoSelecionado != null) {
		                    double preco = (double) modeloTabela.getValueAt(linhaSelecionada, 1);
		                    LocalDate dataEntregaPedido1 = (LocalDate) modeloTabela.getValueAt(linhaSelecionada, 2);
		                    String dataEntregaPedidoString = dataEntregaPedido1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		                    String valorPagamento = (String) modeloTabela.getValueAt(linhaSelecionada, 3);
		                    boolean pagamento = Boolean.parseBoolean(valorPagamento);

		                    double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo preço para o pedido " + numeroPedido, preco));
		                    String novaDataEntrega = JOptionPane.showInputDialog("Digite a nova data de entrega para o pedido " + numeroPedido, dataEntregaPedidoString);
		                    

		                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		                    LocalDate novaData = null;
		                    try {
		                        // Tenta converter a string para LocalDate usando o formato especificado
		                       novaData = LocalDate.parse(novaDataEntrega, formatter);

		                        // Agora, você pode usar a variável "novaData" conforme necessário
		                      

		                        // Restante do código...
		                    } catch (Exception e1) {
		                        // Trate a exceção se a entrada do usuário não estiver no formato esperado
		                        JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
		                        // Ou implemente uma lógica diferente, como solicitar novamente a data, etc.
		                    }
		                    
		                    int resposta = JOptionPane.showConfirmDialog(null, "O pedido foi pago?", "Confirmação de Pagamento", JOptionPane.YES_NO_OPTION);
		                    boolean foiPago = (resposta == JOptionPane.YES_OPTION);
		                    
		                    pedidoSelecionado.setPreco(novoPreco);
		                    pedidoSelecionado.setPagamento(foiPago);
		                    pedidoSelecionado.setDataEntrega(novaData);
		                    
		                    PedidoController p = new PedidoController(JanelaListaPedidos.this, pedidoSelecionado);
		                    p.atualizarPedido();
		                    atualizarTabela();
		                }
			            
			            
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
			        	int numeroPedido = (int) modeloTabela.getValueAt(linhaSelecionada, 0);
			        	PedidoDTO pedidoSelecionado = null;
		                for (PedidoDTO pedido : listaDePedidos) {
		                    if (pedido.getNumero() == numeroPedido) {
		                        pedidoSelecionado = pedido;
		                        PedidoController p = new PedidoController(JanelaListaPedidos.this, pedidoSelecionado);
			                    p.deletar();
			                    atualizarTabela();
			                    break;
		                        
		                    }
		                }
		                
			            
			        } else {
			            JOptionPane.showMessageDialog(null, "Selecione um pedido para excluir.");
			        }
			    }
			});
	  }
	  private void filtrarPedidos(String criterio) {
		    
		    modeloTabela.setRowCount(0);

		   
		    for (PedidoDTO pedido : listaDePedidos) {
		        if (pedido.getDescricao().contains(criterio)  ) {
		            modeloTabela.addRow(new Object[]{pedido.getNumero(), pedido.getDescricao(), pedido.getDataEntrega()});
		        }
		    }
	  }
	  private void atualizarTabela() {
		    modeloTabela.setRowCount(0);
		    adicionarDadosATabela();
		}
	  public static void main(String[]args) {
		  JanelaListaPedidos j = new JanelaListaPedidos();
	  }
}
