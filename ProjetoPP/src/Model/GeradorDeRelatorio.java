package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DTO.ClienteDTO;
import DTO.HistoricoDeCompraDTO;
import DTO.PedidoDTO;
import View.JanelaGerarRelatorio;

public class GeradorDeRelatorio implements ActionListener{

	private JanelaGerarRelatorio gerarRelatorio;

	public GeradorDeRelatorio(JanelaGerarRelatorio gerarRelatorio) {
		this.gerarRelatorio = gerarRelatorio;
	}

	// vai adicionando as informações escolhidas nas box selecionadas
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Escolher fotos")) {
			JFileChooser jfc = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Apenas jpeg, png, jpg", "jpeg", "png", "jpg");
			jfc.setAcceptAllFileFilterUsed(false);
			jfc.addChoosableFileFilter(filtro);
			jfc.setMultiSelectionEnabled(true);
			int resposta = jfc.showOpenDialog(null);
			if (resposta == JFileChooser.APPROVE_OPTION) {
				gerarRelatorio.setFiles(jfc.getSelectedFiles());
				JOptionPane.showMessageDialog(gerarRelatorio, "Fotos selecionadas com sucesso!");

			}
		} else {
			Document doc = new Document(PageSize.A4);

			try {
				OutputStream os = new FileOutputStream("relatório.pdf");
				PdfWriter.getInstance(doc, os);
				doc.open();
				Paragraph pg = new Paragraph("Informações do mês de: " + LocalDate.now().getMonth());
				pg.setAlignment(Element.ALIGN_CENTER);
				doc.add(pg);

				doc.add(new Paragraph("\n"));
				doc.add(new Paragraph());

				boolean flag = false;
				if (gerarRelatorio.getTabelaDeDespesas().isSelected()) {
					flag = true;
					pg = new Paragraph("Tabela de despesas: ");
					doc.add(pg);
					doc.add(new Paragraph("\n"));
					doc.add(new Paragraph());
					PdfPTable table = new PdfPTable(3);
					String[] colunas = { "Nome do material", "Preço", "Data" };

					for (String c : colunas) {
						PdfPCell cell = new PdfPCell(new Phrase(c));
						cell.setBackgroundColor(BaseColor.ORANGE);
						table.addCell(cell);
					}

					for (HistoricoDeCompraDTO h : CentralDeInformacoes.getInstance().getHistorico()) {
						if (h.getDataDaCompra().getMonth().equals(LocalDate.now().getMonth())
								&& h.getDataDaCompra().getYear() == LocalDate.now().getYear()) {

							table.addCell(h.getMaterial().getNome());
							table.addCell(String.valueOf(h.getPreco()));
							table.addCell(h.getDataDaCompra().toString());
						}
					}
					doc.add(table);
					doc.add(new Paragraph("\n"));
					doc.add(new Paragraph());
				}
				if (gerarRelatorio.getTabelaDeVendas().isSelected()) {
					flag = true;
					pg = new Paragraph("Tabela de vendas: ");
					doc.add(pg);
					doc.add(new Paragraph("\n"));
					doc.add(new Paragraph());
					PdfPTable table = new PdfPTable(5);
					String[] colunas = { "Cliente", "Preço", "Data de entrega", "Pagamento", "Status"};

					for (String c : colunas) {
						PdfPCell cell = new PdfPCell(new Phrase(c));
						cell.setBackgroundColor(BaseColor.ORANGE);
						table.addCell(cell);
					}

					for (PedidoDTO h : CentralDeInformacoes.getInstance().getPedidos()) {
						if (h.getDataEntrega().getMonth().equals(LocalDate.now().getMonth())
								&& h.getDataEntrega().getYear() == LocalDate.now().getYear()) {

							table.addCell(h.getCliente().getNome());
							table.addCell(String.valueOf(h.getPreco()));
							table.addCell(h.getDataEntrega().toString());
							table.addCell(h.isPagamento());
							table.addCell(h.isFinalizado());
							
						}
					}
					doc.add(table);
					doc.add(new Paragraph("\n"));
					doc.add(new Paragraph());
				}
				if (gerarRelatorio.getLucros().isSelected()) {
					flag = true;
					double ganhos = 0;
					double gastos = 0;
					
					for (HistoricoDeCompraDTO h : CentralDeInformacoes.getInstance().getHistorico()) {
						if (h.getDataDaCompra().getMonth().equals(LocalDate.now().getMonth())
								&& h.getDataDaCompra().getYear() == LocalDate.now().getYear()) {

							gastos += h.getPreco();
						}
					}
					
					for (PedidoDTO h : CentralDeInformacoes.getInstance().getPedidos()) {
						if (h.getDataEntrega().getMonth().equals(LocalDate.now().getMonth())
								&& h.getDataEntrega().getYear() == LocalDate.now().getYear() && h.isPagamento().equals("Pago")); {

							ganhos += h.getPreco();
							
						}
					}
					double lucroTotal = ganhos-gastos;
					
					pg = new Paragraph("Lucros: ");
					doc.add(pg);
					doc.add(new Paragraph("Ganhos do mês: " + ganhos));
					doc.add(new Paragraph("Gastos do mês: " + gastos));
					doc.add(new Paragraph("Lucro total: " + lucroTotal));
					doc.add(new Paragraph("\n"));
					doc.add(new Paragraph());
				}
				if (gerarRelatorio.getClientesNovos().isSelected()) {
					flag = true;
					doc.add(new Paragraph("Clientes novos: "));
					
					for (ClienteDTO h : CentralDeInformacoes.getInstance().getClientes()) {
						if (h.getDataDeCadastramento().getMonth().equals(LocalDate.now().getMonth())
								&& h.getDataDeCadastramento().getYear() == LocalDate.now().getYear()); {
									doc.add(new Paragraph(h.getNome()+ ", " + h.getEmail() + ": " + h.getCpfECnpj()));
						}
					}
					
					
					doc.add(new Paragraph("\n"));
					doc.add(new Paragraph());
				}
				if (gerarRelatorio.getFiles() != null) {
					doc.add(new Paragraph("Fotos dos produtos: \n"));

					for (File f : gerarRelatorio.getFiles()) {
						Image image = Image.getInstance(f.getAbsolutePath());
						image.scaleToFit(200, 200);
						doc.add(image);
					}

				}

				if (!flag && gerarRelatorio.getFiles() == null) {
					pg = new Paragraph("Sem informações");
					doc.add(pg);
				}
				doc.close();
				JOptionPane.showMessageDialog(gerarRelatorio, "Relatório criado com sucesso!");
			} catch (DocumentException | IOException ex) {
				JOptionPane.showMessageDialog(gerarRelatorio, "Erro ao criar o relatório");
			}

		}
	}
}
