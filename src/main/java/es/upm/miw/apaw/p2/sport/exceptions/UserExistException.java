package es.upm.miw.apaw.p2.sport.exceptions;

public class UserExistException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Ya existe un usuario con ese nick";

	public UserExistException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public UserExistException() {
		this("");
	}
}
