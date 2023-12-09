package Model;

public interface SujeitoObservable {
	
	 void addObserver(Observerint observer);
	 void removeObserver(Observerint observer);
	 void notificarObservadores();
	 void atualizar();

}
