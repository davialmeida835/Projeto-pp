package Controller;

import Model.TipoRoupa;
import Model.TipoRoupaPadrao;
import Model.Vestido;

public class TipoRoupaFactory {
	
	public static TipoRoupa criarTipoRoupa(String nome) {
        if(nome.equals("vistido")){
        	return new Vestido();
        }
        return new TipoRoupaPadrao();
}
	
	}
