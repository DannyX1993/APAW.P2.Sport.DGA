package es.upm.miw.apaw.p2.sport.daos.memory;

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

}
