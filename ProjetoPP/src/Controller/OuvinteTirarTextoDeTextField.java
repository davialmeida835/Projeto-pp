package Controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class OuvinteTirarTextoDeTextField implements FocusListener {

	private String texto;

	public OuvinteTirarTextoDeTextField(String texto) {
		this.texto = texto;
	}

	public void focusGained(FocusEvent e) {
		if (e.getSource() instanceof JPasswordField) {
			JPasswordField jpf = (JPasswordField) e.getSource();
			if (new String(jpf.getPassword()).equals(texto)) {
				jpf.setText("");
				jpf.setEchoChar('\u2022');
			}
		} else {
			JTextField textField = (JTextField) e.getSource();
			if (textField.getText().equals(texto)) {
				textField.setText("");
			}
		}
	}

	public void focusLost(FocusEvent e) {
		if (e.getSource() instanceof JPasswordField) {
			JPasswordField jpf = (JPasswordField) e.getSource();
			if (new String(jpf.getPassword()).equals("")) {
				jpf.setText(texto);
				jpf.setEchoChar((char) 0);
			}
		} else {
			JTextField textField = (JTextField) e.getSource();
			if (textField.getText().isEmpty()) {
				textField.setText(texto);
			}
		}
	}
}
