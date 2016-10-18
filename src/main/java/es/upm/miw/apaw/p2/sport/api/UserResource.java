package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.SportController;
import es.upm.miw.apaw.p2.sport.controllers.UserController;
import es.upm.miw.apaw.p2.sport.wrappers.UsersListWrapper;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidSportFieldException;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidUserFieldException;
import es.upm.miw.apaw.p2.sport.exceptions.UserExistException;

public class UserResource {
	
	// GET **/users
	public UsersListWrapper usersList() {
		return new UserController().userList();
	}
	
	public void createUser(String nick, String email) throws InvalidUserFieldException, UserExistException {
		validateFieldUser(nick);
		validateFieldUser(email);
		UserController userController = new UserController();
		if(userController.checkIfExistNick(nick)) {
			throw new UserExistException(nick);
		}
		userController.createUser(nick, email);
	}
	
	public void addSport(String nick, String sportName) throws InvalidSportFieldException {
		validateFieldUserSport(sportName);
		SportController sportController = new SportController();
		checkIfHaveSport(sportName);
		new UserController().addSport(nick, sportController.getIdByName(sportName));
	}
	
	private void validateFieldUser(String field) throws InvalidUserFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidUserFieldException(field);
		}
	}
	
	private void validateFieldUserSport(String field) throws InvalidSportFieldException {
		if (validateField(field)) {
			throw new InvalidSportFieldException(field);
		}
	}
	
	private boolean validateField(String field) {
		return field == null || field.isEmpty();
	}
	
	private void checkIfHaveSport(String sportName) throws InvalidSportFieldException {
		if(!new SportController().checkIfExistSportByName(sportName)) {
			throw new InvalidSportFieldException();
		}
	}

	public UsersListWrapper getUsersListBySport(String sportName) throws InvalidSportFieldException {
		checkIfHaveSport(sportName);
		return new UserController().getUsersListBySport(sportName);
	}
}