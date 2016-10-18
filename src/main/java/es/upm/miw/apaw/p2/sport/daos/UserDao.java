package es.upm.miw.apaw.p2.sport.daos;

import es.upm.miw.apaw.p2.sport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
	User findByNick(String nick);
}
