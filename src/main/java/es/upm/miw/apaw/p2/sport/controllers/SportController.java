package es.upm.miw.apaw.p2.sport.controllers;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.entities.Sport;

public class SportController {

	public void createSport(String nameSport) {
		DaoFactory.getFactory().getSportDao().create(new Sport(nameSport));
	}
	
	public boolean checkIfExistSportByName(String sportName) {
		Sport sport = DaoFactory.getFactory().getSportDao().findByName(sportName);
		return (sport == null) ? false : true;
	}
	
	public Integer getIdByName(String sportName) {
		return DaoFactory.getFactory().getSportDao().findByName(sportName).getId();
	}
	
}
