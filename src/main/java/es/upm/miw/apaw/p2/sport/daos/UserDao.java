package es.upm.miw.apaw.p2.sport.daos;

import java.util.List;
import es.upm.miw.apaw.p2.sport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
	
	User findByNick(String nick);
	
	List<User> findBySport(Integer sportId);
	
}
