package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataInvalidaException extends Exception {
	
	LocalDateTime data;
	DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	String dataFormatada = data.format(formatadorData);

	

}
