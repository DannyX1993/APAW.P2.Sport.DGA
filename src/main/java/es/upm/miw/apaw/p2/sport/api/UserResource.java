package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.UserController;
import es.upm.miw.apaw.p2.sport.wrappers.UsersListWrapper;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidUserFieldException;

public class UserResource {
	
	// GET **/users
	public UsersListWrapper usersList() {
		return new UserController().userList();
	}
	
	public void createUser(String nick, String email) throws InvalidUserFieldException {
		validateField(nick);
		validateField(email);
		// TODO -> COMPROBAR SI EL NICK YA EXISTE Y SI EXISTE ERROR
		new UserController().createUser(nick, email);
	}
	
	private void validateField(String field) throws InvalidUserFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidUserFieldException(field);
		}
	}

	public void addSportToUser(String sportName) {
		new UserController().addSportToUser(sportName);
	}
}