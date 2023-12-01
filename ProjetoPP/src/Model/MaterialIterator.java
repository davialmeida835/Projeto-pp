package Model;

import java.util.Iterator;

import DTO.MaterialDTO;

public class MaterialIterator implements Iterator<MaterialDTO>{

	private MaterialDTO[] materiais;
	private int indice;
	
	public boolean hasNext() {
		if (materiais == null) {
			return false;
		}
		return materiais[indice] != null;
	}

	public MaterialDTO next() {
		return materiais[indice++];
	}

	
}
