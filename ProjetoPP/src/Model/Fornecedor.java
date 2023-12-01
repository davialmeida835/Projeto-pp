package Model;

public class Fornecedor {
	private String nome;
    private String telefone;
    private String materiaisFornecidos;

    public Fornecedor(String nome, String telefone, String materiaisFornecidos) {
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setMateriaisFornecidos(materiaisFornecidos);
    }

	public String getMateriaisFornecidos() {
		return materiaisFornecidos;
	}

	public void setMateriaisFornecidos(String materiaisFornecidos) {
		this.materiaisFornecidos = materiaisFornecidos;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
