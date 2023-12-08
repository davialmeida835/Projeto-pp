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

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import Controller.PedidoController;
import DTO.ClienteDTO;
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
		addTexto(50,365,255,20,"Ganhaos do Mês: $"+obterGanhos()+" Reais");
        addBotaoDeVoltar();
        adicionarBotoesAtualizarExcluir();
        configurarTabela();
        adicionarDadosATabela();
        repaint();
        addbo();
        setVisible(true);
	}
	public double obterGanhos() {
		
		double ganho = 0;
		LocalDate hoje = LocalDate.now();
		for(PedidoDTO p : CentralDeInformacoes.getInstance().getPedidos()) {
			 if (p.isPagamento()=="Pago") {
	                LocalDate dataEntrega = p.getDataDePagamento();

	                // Verifica se a data de entrega esta no mês atual
	                if (dataEntrega != null && dataEntrega.getMonth() == hoje.getMonth()) {
	                    ganho += p.getPreco();
	                }
	            }
	        }

	        return ganho;
			
		}

	public void addbo() {
		JButton botaoAtualizarStatus = addBotao(350, 400, 150, 30, "Atualizar Status", new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int linhaSelecionada = tabelaPedidos.getSelectedRow();
	            if (linhaSelecionada != -1) {
	                // Usando o índice da linha selecionada para acessar o pedido correspondente na lista
	                PedidoDTO pedidoSelecionado = listaDePedidos.get(linhaSelecionada);

	                int resposta = JOptionPane.showConfirmDialog(null, "O pedido foi finalizado?", "Confirmação de Status", JOptionPane.YES_NO_OPTION);
	                boolean foiFinalizado = (resposta == JOptionPane.YES_OPTION);

	                pedidoSelecionado.setFinalizado(foiFinalizado);
	                
	                if( foiFinalizado) {
	                	 enviarEmail(pedidoSelecionado.getCliente(),pedidoSelecionado);
	                }
	                PedidoController p = new PedidoController(JanelaListaPedidos.this, pedidoSelecionado);
	                p.atualizarPedido();
	                atualizarTabela();
	            } else {
	                JOptionPane.showMessageDialog(null, "Selecione um pedido para atualizar o status.");
	            }
	        }
	    });
	    
	}
	private void enviarEmail(ClienteDTO cliente,PedidoDTO pedido) {
	    SimpleEmail email = new SimpleEmail();
	    try {
	        // Configuração do e-mail
	        email.setHostName("smtp.gmail.com");
	        email.setAuthentication("mensageiroct@gmail.com", "ocmghxpsdmtryxkn");
	        email.setSSL(true);

	        // Construção do e-mail
	        email.addTo(cliente.getEmail());
	        email.setFrom(CentralDeInformacoes.getInstance().getUsuario().getEmail());
	        email.setSubject("Pedido Finalizado!!");
	        String mensagem = "Prezado(a) " + cliente.getNome() + ",\n\n"
	                + "Agradecemos por escolher nossa loja! Seu pedido foi finalizado com sucesso.\n"
	                + "Agora, estamos aguardando ansiosamente sua retirada na loja.\n"
	                + "Detalhes do Pedido:\n"
	                + "Total do Pedido: R$ " + pedido.getPreco() + "\n\n"
	                + "Caso tenha alguma dúvida ou problema, entre em contato conosco.\n\n"
	                + "Atenciosamente,\n"
	                + "Equipe da Loja";
	        email.setMsg(mensagem);
	        // Envio do e-mail
	        email.send();
	    } catch (EmailException e) {
	        System.out.println("Falha ao enviar o email!");
	    }
	}

	private void configurarTabela() {
		modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Cliente");
        modeloTabela.addColumn("Preço");
        modeloTabela.addColumn("Data de Entrega");
        modeloTabela.addColumn("Pagamento");
        modeloTabela.addColumn("Status");
        
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
	    if(listaDePedidos!=null) {
		for (PedidoDTO pedido : listaDePedidos) {
	        modeloTabela.addRow(new Object[]{pedido.getCliente().getNome(), pedido.getPreco(), pedido.getDataEntrega(),pedido.isPagamento(),pedido.isFinalizado()});
	    }
	    }
	}
	  private void adicionarBotoesAtualizarExcluir() {
		  JButton botaoAtualizar = addBotao(50, 400, 100, 30, "Atualizar", new ActionListener() {
			 
			    public void actionPerformed(ActionEvent e) {
			        
			        int linhaSelecionada = tabelaPedidos.getSelectedRow(); 
			        if (linhaSelecionada != -1) {
			            
			        	

		                // Encontrar o pedido correspondente na lista
			        	PedidoDTO pedidoSelecionado = listaDePedidos.get(linhaSelecionada);
		                

		                if (pedidoSelecionado != null) {
		                    double preco = (double) modeloTabela.getValueAt(linhaSelecionada, 1);
		                    LocalDate dataEntregaPedido1 = (LocalDate) modeloTabela.getValueAt(linhaSelecionada, 2);
		                    String dataEntregaPedidoString = dataEntregaPedido1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		                    String valorPagamento = (String) modeloTabela.getValueAt(linhaSelecionada, 3);
		                    boolean pagamento = Boolean.parseBoolean(valorPagamento);

		                    double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo preço para o pedido " +  preco));
		                    
		                    

		                   
		                    LocalDate novaData = null;
		                    do {
		                        String novaDataEntrega = JOptionPane.showInputDialog("Digite a nova data de entrega para o pedido " +  dataEntregaPedidoString);

		                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		                        try {
		                            // Tenta converter a string para LocalDate usando o formato especificado
		                            novaData = LocalDate.parse(novaDataEntrega, formatter);
		                            // Se a conversão for bem-sucedida, sai do loop
		                            break;
		                        } catch (Exception e1) {
		                            // Trate a exceção se a entrada do usuário não estiver no formato esperado
		                            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
		                        }
		                    } while (true);
		                    
		                    int resposta = JOptionPane.showConfirmDialog(null, "O pedido foi pago?", "Confirmação de Pagamento", JOptionPane.YES_NO_OPTION);
		                    boolean foiPago = (resposta == JOptionPane.YES_OPTION);
		                    if (foiPago) {
		                        // Se o pagamento foi confirmado, defina a dataDePagamento como a data atual
		                        pedidoSelecionado.setDataDePagamento(LocalDate.now());
		                    }
		                    
		                    pedidoSelecionado.setPreco(novoPreco);
		                    pedidoSelecionado.setPagamento(foiPago);
		                    pedidoSelecionado.setDataEntrega(novaData);
		                    
		                    System.out.println(pedidoSelecionado.getNumero());
		                    
		                    PedidoController p = new PedidoController(JanelaListaPedidos.this, pedidoSelecionado);
		                    p.atualizarPedido();
		                    atualizarTabela();
		                }
			            
			            
			        } else {
			            JOptionPane.showMessageDialog(null, "Selecione um pedido para atualizar.");
			        }
			    }
			});

			JButton botaoExcluir = addBotao(200, 400, 100, 30, "Excluir", new ActionListener() {
			 
			    public void actionPerformed(ActionEvent e) {
			        
			        int linhaSelecionada = tabelaPedidos.getSelectedRow();
			        if (linhaSelecionada != -1) {
			        	
			        	
			        	PedidoDTO pedidoSelecionado = listaDePedidos.get(linhaSelecionada);
		                
		                PedidoController p = new PedidoController(JanelaListaPedidos.this, pedidoSelecionado);
			            p.deletar();
			            atualizarTabela();
			                    
		                        
		                    
		                
		                
			            
			        } else {
			            JOptionPane.showMessageDialog(null, "Selecione um pedido para excluir.");
			        }
			    }
			});
	  }
	  private void filtrarPedidos(String criterio) {
		    
		    modeloTabela.setRowCount(0);

		   
		    for (PedidoDTO pedido : listaDePedidos) {
		        if (pedido.getCliente().getNome().contains(criterio)  ) {
		            modeloTabela.addRow(new Object[]{pedido.getCliente().getNome(), pedido.getPreco(), pedido.getDataEntrega(),pedido.isPagamento(),pedido.isFinalizado()});
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
