package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OuvinteDoCampoSomenteNumeros implements KeyListener{

	public void keyTyped(KeyEvent e) {
		char l = e.getKeyChar();
		if(!Character.isDigit(l)) {
			e.consume();
		}
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}
	
	

}
