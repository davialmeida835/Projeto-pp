package Model;

public class TipoRoupaFactory {
	
	 public static TipoRoupa criarTipoRoupa(String nome) {
	        switch (nome.toLowerCase()) {
	            case "vestido":
	                return new Vestido();
	            case "camiseta":
	                return new Camiseta();
	            case "calca":
	                return new Calca();
	            case "jaqueta":
	                return new Jaqueta();
	            case "meia":
	                return new Meia();
	            case "blusa":
	                return new Blusa();
	            case "shorts":
	                return new Shorts();
	            default:
	                return new Outros();
	        }
	    }
       
}