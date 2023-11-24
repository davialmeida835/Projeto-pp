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
import javax.swing.table.AbstractTableModel;

public class JanelaFinanceiro extends JanelaPadrao{
	
    private JTable tabelaPagamentos;
    private PagamentoTableModel tableModel;

    public JanelaFinanceiro() {
        addTexto(0, 10, 550, 30, "Verifique Relatório Mensal", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
        addTexto(0, 30, 550, 30, "Verifique Pagamentos", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);

     
        tableModel = new PagamentoTableModel();
        tabelaPagamentos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaPagamentos);
        scrollPane.setBounds(50, 70, 450, 300);
        add(scrollPane);
        adicionarBotaoAtualizar();
        addBotaoDeVoltar();
        setVisible(true);
    }
    private void adicionarBotaoAtualizar() {
        JButton botaoAtualizar = new JButton("Atualizar Status");
        botaoAtualizar.setBounds(185, 400, 200, 30);
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarStatusPagamento();
            }
        });
        add(botaoAtualizar);
    }

   
    private void atualizarStatusPagamento() {
        int linhaSelecionada = tabelaPagamentos.getSelectedRow();
        if (linhaSelecionada != -1) {
            String numeroPedido = (String) tableModel.getValueAt(linhaSelecionada, 0);
            String cliente = (String) tableModel.getValueAt(linhaSelecionada, 1);
            String statusAtual = (String) tableModel.getValueAt(linhaSelecionada, 2);

          
            String novoStatus = statusAtual.equals("Pendente") ? "Pago" : "Pendente";

           
            tableModel.setValueAt(novoStatus, linhaSelecionada, 2);

            JOptionPane.showMessageDialog(this, "Status de pagamento atualizado para " + novoStatus +
                    " para o pedido " + numeroPedido + " do cliente " + cliente, "Atualização Concluída", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um pagamento para atualizar o status.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    
    private class PagamentoTableModel extends AbstractTableModel {
        private String[] colunas = {"Número do Pedido", "Cliente", "Status do Pagamento"};
        private List<Object[]> data;

        public PagamentoTableModel() {
           
            data = new ArrayList<>();
           
            data.add(new Object[]{"1", "Cliente 1", "Pago"});
            data.add(new Object[]{"2", "Cliente 2", "Pendente"});
            data.add(new Object[]{"3", "Cliente 3", "Pago"});
            data.add(new Object[]{"4", "Cliente 4", "Pendente"});
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return colunas.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data.get(rowIndex)[columnIndex];
        }

        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            data.get(rowIndex)[columnIndex] = value;
            fireTableCellUpdated(rowIndex, columnIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
         
            return columnIndex == 2;
        }

        @Override
        public String getColumnName(int column) {
            return colunas[column];
        }
    }
	public static void main(String [] args) {
		JanelaFinanceiro j = new JanelaFinanceiro();
	}

}
