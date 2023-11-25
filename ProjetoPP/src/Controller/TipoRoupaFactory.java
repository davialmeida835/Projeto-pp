package Controller;

import Model.TipoRoupa;
import Model.TipoRoupaPadrao;

public class TipoRoupaFactory {
	
	public static TipoRoupa criarTipoRoupa(String descricao, int preco) {
        return new TipoRoupaPadrao(descricao, preco);
    }
}
