package Model;

public class ClientePessoaJuridica extends Cliente{
	
	private long cnpj;
	
	public ClientePessoaJuridica(String nome, long telefone, String email, long cnpj) {
		super(nome, telefone, email);
		this.cnpj = cnpj;
	}
	public long getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getIdentificador() {
		return String.valueOf(cnpj);
	}
}
