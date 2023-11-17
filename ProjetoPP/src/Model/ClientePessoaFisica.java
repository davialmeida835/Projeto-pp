package Model;

public class ClientePessoaFisica extends Cliente{

	private long cpf;
	
	public ClientePessoaFisica(String nome, long telefone, String email, long cpf) {
		super(nome, telefone, email);
		this.cpf = cpf;
	}
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getIdentificador() {
		return String.valueOf(cpf);
	}
	
}
