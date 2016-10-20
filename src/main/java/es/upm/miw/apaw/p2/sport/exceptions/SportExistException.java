package es.upm.miw.apaw.p2.sport.exceptions;

public class SportExistException extends Exception {
	
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Ya existe un deporte con ese nombre";

	public SportExistException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public SportExistException() {
		this("");
	}
	
}
