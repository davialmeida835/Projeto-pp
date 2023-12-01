package DTO;

public class FornecedorDTO {
	
	private String nome;
    private String telefone;
    private String materiaisFornecidos;

    public FornecedorDTO(String nome, String telefone, String materiaisFornecidos) {
        this.nome = nome;
        this.telefone = telefone;
        this.materiaisFornecidos = materiaisFornecidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMateriaisFornecidos() {
        return materiaisFornecidos;
    }

    public void setMateriaisFornecidos(String materiaisFornecidos) {
        this.materiaisFornecidos = materiaisFornecidos;
    }


}
