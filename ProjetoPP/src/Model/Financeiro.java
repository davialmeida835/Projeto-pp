package Model;

import java.util.ArrayList;
import java.util.List;

public class Financeiro {

	private List<Material> materiais = new ArrayList<>();
	
	public void addMaterialComprado(Material material) {
		materiais.add(material);
	}
	
	
}
