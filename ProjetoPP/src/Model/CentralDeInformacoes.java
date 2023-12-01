package Model;

import java.util.ArrayList;
import java.util.List;

public class CentralDeInformacoes {

	private Usuario usuario;
	private List<Cliente> clientes = new ArrayList<>();
	private List<Material> materiais = new ArrayList<>();
	
	private volatile static CentralDeInformacoes instance;

	private CentralDeInformacoes() {};

	public static CentralDeInformacoes getInstance() {
		if (instance == null) {
			synchronized (CentralDeInformacoes.class) {
				if (instance == null) {
					instance = new CentralDeInformacoes();
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

	public List<Material> getMateriais() {
		return materiais;
	}
	
}
