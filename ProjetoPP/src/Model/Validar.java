package Model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validar {

	//método para validar os dados do cadastro
	public static String validarDados(String email, String senha, String nome, String telefone, String data)
			throws DadosInvalidosException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate ldt;
		try {
			ldt = LocalDate.parse(data, formatter);
		} catch (DateTimeException d) {
			throw new DadosInvalidosException("Digite uma data válida");
		}

		int idade = LocalDateTime.now().getYear() - ldt.getYear();

		try {
			InternetAddress eValido = new InternetAddress(email);
			eValido.validate();
		} catch (AddressException e) {
			throw new DadosInvalidosException("Digite um e-mail válido");
		}

		if (idade < 18) {
			throw new DadosInvalidosException("Digite uma data de nascimento válida");
		} else if (senha.length() < 8 || senha.equals("Digite sua senha")) {
			throw new DadosInvalidosException("Digite uma senha com pelo menos 8 dígitos");
		} else if (nome.length() == 0 || nome.equals("Digite seu nome completo")) {
			throw new DadosInvalidosException("Preencha o campo do nome");
		} else if (telefone.length() != 11) {
			throw new DadosInvalidosException("Digite um número de telefone válido");
		}
		return "Cadastro efetuado com sucesso";	
	}
	
	public static String validar(String telefone, String email, String numeroDoTipo) throws DadosInvalidosException {
		
		if(numeroDoTipo.contains(" ")) {
			throw new DadosInvalidosException("Digite um número de identificação válido!");
		}
		
		if (telefone.contains(" ")) {
			throw new DadosInvalidosException("Digite um número de telefone válido!");
		}
		
		try {
			InternetAddress eValido = new InternetAddress(email);
			eValido.validate();
		} catch (AddressException e) {
			throw new DadosInvalidosException("Digite um e-mail válido!");
		}

		return "Fornecedor salvo com sucesso";
		
	}
	
	
	//Método para validar o cnpj
//	public static boolean validarCnpj(String cnpj) {
//		if (cnpj.length() == 18) {
//			cnpj = cnpj.replace(".", "").replace("-", "");
//		}
//		try {
//			if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
//					|| cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
//					|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
//					|| cnpj.equals("99999999999999") || (cnpj.length() != 14)) {
//				return false;
//			}
//
//			String[] digitosCnpj = cnpj.split("");
//
//			int soma = 0;
//			int peso = 2;
//			int primeiroNum;
//			int segundoNum;
//			for (int i = 11; i >= 0; i--) {
//				soma += Integer.parseInt(digitosCnpj[i]) * peso;
//
//				if (peso == 9) {
//					peso = 2;
//				} else {
//					peso++;
//				}
//			}
//
//			if (soma % 11 == 0 || soma % 11 == 1) {
//				primeiroNum = 0;
//			} else {
//				primeiroNum = 11 - (soma % 11);
//			}
//
//			if (primeiroNum != Integer.parseInt(cnpj.split("")[12])) {
//				return false;
//			}
//
//			soma = 0;
//			peso = 2;
//			for (int i = 12; i >= 0; i--) {
//				soma += Integer.parseInt(digitosCnpj[i]) * peso;
//
//				if (peso == 9) {
//					peso = 2;
//				} else {
//					peso++;
//				}
//			}
//
//			if (soma % 11 == 0 || soma % 11 == 1) {
//				segundoNum = 0;
//			} else {
//				segundoNum = 11 - (soma % 11);
//			}
//
//			if (segundoNum != Integer.parseInt(cnpj.split("")[13])) {
//				return false;
//			}
//
//		} catch (NumberFormatException e) {
//			return false;
//		}
//
//		return true;
//	}

	//método para validar o cpf
//	public static boolean validarCpf(String cpf) {
//		if (cpf.length() == 14) {
//			cpf = cpf.replace(".", "").replace("-", "");
//		}
//		try {
//			if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
//					|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
//					|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
//					|| cpf.equals("99999999999") || (cpf.length() != 11)) {
//				return (false);
//			}
//
//			String[] digitosCpf = cpf.split("");
//
//			int soma = 0;
//			int peso = 10;
//			int primeiroNum;
//			int segundoNum;
//			for (int i = 0; i < 9; i++) {
//				soma += Integer.parseInt(digitosCpf[i]) * peso;
//
//				peso -= 1;
//			}
//
//			if (soma % 11 == 10 || soma % 11 == 11) {
//				primeiroNum = 0;
//			} else {
//				primeiroNum = 11 - (soma % 11);
//			}
//
//			if (primeiroNum != Integer.parseInt(cpf.split("")[9])) {
//				return false;
//			}
//
//			peso = 11;
//			soma = 0;
//			for (int i = 0; i < 10; i++) {
//				soma += Integer.parseInt(digitosCpf[i]) * peso;
//
//				peso -= 1;
//			}
//
//			if (soma % 11 == 10 || soma % 11 == 11) {
//				segundoNum = 0;
//			} else {
//				segundoNum = 11 - (soma % 11);
//			}
//
//			if (segundoNum != Integer.parseInt(cpf.split("")[10])) {
//				return false;
//			}
//		} catch (NumberFormatException e) {
//			return false;
//		}
//
//		return true;
//	}
	
	//método para validar a hora
	public static LocalDateTime validarDataEHora(String data) throws DadosInvalidosException{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		LocalDateTime ldt;
		try {
			ldt = LocalDateTime.parse(data, formatter);
			return ldt;
		} catch (DateTimeException d) {
			throw new DadosInvalidosException("Digite uma data válida");
		}
	}
}
