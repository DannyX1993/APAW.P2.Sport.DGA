package es.upm.miw.apaw.p2.sport.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.upm.miw.apaw.p2.sport.daos.SportDao;
import es.upm.miw.apaw.p2.sport.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

	
	public SportDaoMemory() {
		this.setMap(new HashMap<Integer, Sport>());
	}

	@Override
	protected Integer getId(Sport entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Sport entity, Integer id) {
		entity.setId(id);	
	}

	@Override
	public Sport findByName(String sportName) {
		List<Sport> sportsList = this.findAll();
		for(Sport sport : sportsList) {
			if(sport.getName() == sportName) {
				return sport;
			}
		}
		return null;
	}
	

}
