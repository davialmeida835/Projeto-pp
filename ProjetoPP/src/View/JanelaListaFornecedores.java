package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class JanelaListaFornecedores extends JanelaPadrao{
	
	 	private JTable tabelaFornecedores;
	    private FornecedorTableModel tableModel;
	    private JTextField campoFiltro;
	    public JanelaListaFornecedores() {
	        addTexto(0, 10, 550, 30, "Lista de Fornecedores", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
	        addTexto(50,65,250,30,"Filtrar fornecedor por nome:");
	       
	        tableModel = new FornecedorTableModel();
	        tabelaFornecedores = new JTable(tableModel);
	        JScrollPane scrollPane = new JScrollPane(tabelaFornecedores);
	        scrollPane.setBounds(50, 150, 450, 200);
	        add(scrollPane);

	        adicionarBotaoAtualizar();
	        adicionarBotaoDeletar();
	        addBotaoDeVoltar();
	        
	        campoFiltro = new JTextField();
	        campoFiltro.setBounds(50, 95, 325, 30);
	        add(campoFiltro);
	        adicionarBotaoFiltrar();
	        setVisible(true);
	        
	    }
	    private void adicionarBotaoFiltrar() {
	        JButton botaoFiltrar = new JButton("Filtrar");
	        botaoFiltrar.setBounds(400, 95, 100, 30);
	        botaoFiltrar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                filtrarFornecedores();
	            }
	        });
	        add(botaoFiltrar);
	    }

	    private void filtrarFornecedores() {
	        String nomeFiltro = campoFiltro.getText().trim().toLowerCase();

	        
	        List<Object[]> dadosFiltrados = new ArrayList<>();

	   
	        for (Object[] fornecedor : tableModel.getData()) {
	            String nomeAtual = ((String) fornecedor[0]).toLowerCase();

	            
	            if (nomeAtual.contains(nomeFiltro)) {
	                dadosFiltrados.add(fornecedor);
	            }
	        }

	        
	        tableModel.setNewData(dadosFiltrados);
	    }

	    private void adicionarBotaoAtualizar() {
	        JButton botaoAtualizar = new JButton("Atualizar");
	        botaoAtualizar.setBounds(150, 400, 100, 30);
	        botaoAtualizar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                atualizarFornecedor();
	            }
	        });
	        add(botaoAtualizar);
	    }

	    private void adicionarBotaoDeletar() {
	        JButton botaoDeletar = new JButton("Deletar");
	        botaoDeletar.setBounds(300, 400, 100, 30);
	        botaoDeletar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                deletarFornecedor();
	            }
	        });
	        add(botaoDeletar);
	    }
	    
	    private void atualizarFornecedor() {
	        int linhaSelecionada = tabelaFornecedores.getSelectedRow();
	        if (linhaSelecionada != -1) {
	            
	            String nomeAtual = (String) tableModel.getValueAt(linhaSelecionada, 0);
	            String telefoneAtual = (String) tableModel.getValueAt(linhaSelecionada, 1);
	            String materiaisAtual = (String) tableModel.getValueAt(linhaSelecionada, 2);

	           
	            String novoNome = JOptionPane.showInputDialog(this, "Digite o novo nome do fornecedor:", nomeAtual);
	            String novoTelefone = JOptionPane.showInputDialog(this, "Digite o novo telefone do fornecedor:", telefoneAtual);
	            String novosMateriais = JOptionPane.showInputDialog(this, "Digite os novos materiais fornecidos pelo fornecedor:", materiaisAtual);

	           
	            if (novoNome != null && novoTelefone != null && novosMateriais != null) {
	                
	                tableModel.setValueAt(novoNome, linhaSelecionada, 0);
	                tableModel.setValueAt(novoTelefone, linhaSelecionada, 1);
	                tableModel.setValueAt(novosMateriais, linhaSelecionada, 2);

	                JOptionPane.showMessageDialog(this, "Fornecedor atualizado com sucesso.", "Atualização Concluída", JOptionPane.INFORMATION_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Selecione um fornecedor para atualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
	        }
	    }

	    private void deletarFornecedor() {
	        int linhaSelecionada = tabelaFornecedores.getSelectedRow();
	        if (linhaSelecionada != -1) {
	            String nome = (String) tableModel.getValueAt(linhaSelecionada, 0);
	            String telefone = (String) tableModel.getValueAt(linhaSelecionada, 1);
	            String materiais = (String) tableModel.getValueAt(linhaSelecionada, 2);

	          
	            int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente deletar o fornecedor:\n\n"
	                    + "Nome: " + nome + "\nTelefone: " + telefone + "\nMateriais Fornecidos: " + materiais,
	                    "Confirmar Deleção", JOptionPane.YES_NO_OPTION);

	            if (opcao == JOptionPane.YES_OPTION) {
	               
	                tableModel.removeRow(linhaSelecionada);
	                JOptionPane.showMessageDialog(this, "Fornecedor deletado com sucesso.", "Deleção Concluída", JOptionPane.INFORMATION_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Selecione um fornecedor para deletar.", "Aviso", JOptionPane.WARNING_MESSAGE);
	        }
	    }
	    

	    
	    private class FornecedorTableModel extends AbstractTableModel {
	        private String[] colunas = {"Nome", "Telefone", "Materiais Fornecidos"};
	        private Object[][] data = {
	                {"Fornecedor 1", "123-456-7890", "Material A, Material B"},
	                {"Fornecedor 2", "987-654-3210", "Material C, Material D"}
	              
	        };
	        
	        public Object[][] getData() {
	            return data;
	        }

	        public void setNewData(List<Object[]> newData) {
	            data = newData.toArray(new Object[0][]);
	            fireTableDataChanged();
	        }

	        @Override
	        public int getRowCount() {
	            return data.length;
	        }

	        @Override
	        public int getColumnCount() {
	            return colunas.length;
	        }

	        @Override
	        public Object getValueAt(int rowIndex, int columnIndex) {
	            return data[rowIndex][columnIndex];
	        }

	        @Override
	        public String getColumnName(int column) {
	            return colunas[column];
	        }

	       
	        public void removeRow(int row) {
	         
	            List<Object[]> dataList = new ArrayList<>(Arrays.asList(data));
	            dataList.remove(row);
	            data = dataList.toArray(new Object[0][]);

	        
	            fireTableRowsDeleted(row, row);
	        }
	    }


    public static void main(String[] args) {
        new JanelaListaFornecedores();
    }

}
