package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class CentralDeInformacoes {

	private volatile static CentralDeInformacoes instance;

	private CentralDeInformacoes() {
	};

	private Usuario usuario;
	private List<Cliente> clientes = new ArrayList<>();
	private List<TipoDeMaterial> tipoDeMateriais = new ArrayList<>();
	private List<Material> materiais = new ArrayList<>();
	private List<Fornecedor> fornecedores = new ArrayList<>();
	
	public static CentralDeInformacoes getInstance() {
		if (instance == null) {
			synchronized (CentralDeInformacoes.class) {
				if (instance == null) {
					instance = recuperarCentral("central");
				}
			}
		}
		return instance;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void addMaterial(Material material) {
		materiais.add(material);
	}

	public void addTipoDeMaterial(TipoDeMaterial tipoDeMaterial) {
		tipoDeMateriais.add(tipoDeMaterial);
	}

	public List<TipoDeMaterial> getTipoDeMateriais() {
		return tipoDeMateriais;
	}

	public List<Material> getMateriais() {
		return materiais;
	}
	public void addFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }
    
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

	private static CentralDeInformacoes recuperarCentral(String nomeDoArquivo) {
		XStream xStream = new XStream(new DomDriver());
		xStream.addPermission(AnyTypePermission.ANY);

		FileReader leitor = null;

		try {
			leitor = new FileReader(nomeDoArquivo + ".xml");
			CentralDeInformacoes central = (CentralDeInformacoes) xStream.fromXML(leitor);
			return central;
		} catch (FileNotFoundException e) {
			return new CentralDeInformacoes();
		}

	}
}
