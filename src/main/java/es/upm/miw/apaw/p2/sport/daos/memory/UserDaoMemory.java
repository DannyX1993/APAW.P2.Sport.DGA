package es.upm.miw.apaw.p2.sport.daos.memory;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import es.upm.miw.apaw.p2.sport.daos.UserDao;
import es.upm.miw.apaw.p2.sport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	
	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}
	
	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer ID) {
		entity.setId(ID);
	}

	@Override
	public User findByNick(String nick) {
		List<User> usersList = this.findAll();
		for(User user : usersList) {
			if(user.getNick().equals(nick)) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public List<User> findBySport(Integer sportId) {
		List<User> usersList = this.findAll();
		List<User> filteredUsers = new ArrayList<User>();
		for(User user : usersList) {
			if(user.haveSport(sportId)) {
				filteredUsers.add(user);
			}
		}
		return filteredUsers;
	}

}
