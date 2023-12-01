package Model;

import java.util.ArrayList;
import java.util.List;

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
}
