package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import Model.CentralDeInformacoes;


public class Persistencia {

	public static void salvarCentral(CentralDeInformacoes central, String nomeDoArquivo) {
		XStream xStream = new XStream(new DomDriver());

		String xml = xStream.toXML(central); // Transforma a central em um texto
		File endereco = new File(nomeDoArquivo + ".xml");

		try {
			PrintWriter escritor = new PrintWriter(endereco); // executa o arquivo xml
			escritor.println(xml); // escreve o texto no arquivo
			escritor.flush(); // salva o arquivo
			escritor.close(); // encerra o escritor
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static CentralDeInformacoes recuperarCentral(String nomeDoArquivo) {
		XStream xStream = new XStream(new DomDriver());
		xStream.addPermission(AnyTypePermission.ANY);

		FileReader leitor = null;

		try {
			leitor = new FileReader(nomeDoArquivo + ".xml");
			CentralDeInformacoes central = (CentralDeInformacoes) xStream.fromXML(leitor);
			return central;
		} catch (FileNotFoundException e) {
			return CentralDeInformacoes.getInstance();
		}

	}
}
