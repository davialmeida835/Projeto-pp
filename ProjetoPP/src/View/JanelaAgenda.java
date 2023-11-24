package View;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JanelaAgenda extends JanelaPadrao{
	
	   private JTable tabelaPedidos;
	    private PedidoTableModel tableModel;

	    public JanelaAgenda() {
	        addTexto(0, 10, 550, 30, "Agenda Do Dia", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
	        addTexto(0, 30, 550, 30, "Verificar Agenda", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);

	    
	        tableModel = new PedidoTableModel();
	        tabelaPedidos = new JTable(tableModel);
	        JScrollPane scrollPane = new JScrollPane(tabelaPedidos);
	        scrollPane.setBounds(50, 70, 450, 350);
	        add(scrollPane);

	        addBotaoDeVoltar();
	        setVisible(true);
	    }

	    
	    private class PedidoTableModel extends AbstractTableModel {
	        private String[] colunas = {"Número do Pedido", "Cliente", "Produto", "Quantidade", "Data"};
	        private List<Object[]> data;

	        public PedidoTableModel() {
	          
	            data = new ArrayList<>();
	            
	            data.add(new Object[]{"1", "Cliente 1", "Produto A", 5, LocalDate.now()});
	            data.add(new Object[]{"2", "Cliente 2", "Produto B", 3, LocalDate.now()});
	           
	            data.add(new Object[]{"3", "Cliente 3", "Produto C", 2, LocalDate.now().plusDays(1)});
	            data.add(new Object[]{"4", "Cliente 4", "Produto D", 1, LocalDate.now().minusDays(1)});

	            
	            LocalDate today = LocalDate.now();
	            List<Object[]> newData = new ArrayList<>();
	            for (Object[] pedido : data) {
	                LocalDate dataPedido = (LocalDate) pedido[4];
	                if (dataPedido.equals(today)) {
	                    newData.add(pedido);
	                }
	            }
	            data = newData;
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
	        public String getColumnName(int column) {
	            return colunas[column];
	        }
	    }

	public static void main(String[] args) {
		JanelaAgenda j =  new JanelaAgenda();
	}
}
