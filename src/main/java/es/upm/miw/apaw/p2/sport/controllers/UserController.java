package es.upm.miw.apaw.p2.sport.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.entities.Sport;
import es.upm.miw.apaw.p2.sport.entities.User;
import es.upm.miw.apaw.p2.sport.wrappers.UserWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UsersListWrapper;

public class UserController {

	public UsersListWrapper userList(){
		List<User> usersList = DaoFactory.getFactory().getUserDao().findAll();
		UsersListWrapper usersListWrapper = new UsersListWrapper();
		for (User user : usersList) {
			ArrayList<String> sportsList = user.getStringSportsList();
			usersListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail(), sportsList));
		}
		return usersListWrapper;
	}
	
	public void createUser(String nick, String email) {
		DaoFactory.getFactory().getUserDao().create(new User(nick, email));
	}
	
	public void addSport(String nick, String sportName) {
		User user = DaoFactory.getFactory().getUserDao().findByNick(nick);
		Sport sport = DaoFactory.getFactory().getSportDao().findByName(sportName);
		if(sport != null) {
			user.addSport(sport);
		}
	}

	public boolean checkIfExistNick(String nick) {
		User user = DaoFactory.getFactory().getUserDao().findByNick(nick);
		return (user == null) ? false : true;
	}

	public UsersListWrapper getUsersListBySport(String sportName) {
		Integer sportId = DaoFactory.getFactory().getSportDao().findByName(sportName).getId();
		List<User> usersList = DaoFactory.getFactory().getUserDao().findBySport(sportId);
		UsersListWrapper usersListWrapper = new UsersListWrapper();
		for(User user : usersList) {
			usersListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail(), user.getStringSportsList()));
		}
		return usersListWrapper;
	}
	
}
