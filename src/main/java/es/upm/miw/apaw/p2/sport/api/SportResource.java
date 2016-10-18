package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.SportController;
import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidSportFieldException;
import es.upm.miw.apaw.p2.sport.exceptions.SportExistException;

public class SportResource {

	public void createSport(String sportName) throws InvalidSportFieldException, SportExistException {
		validateField(sportName);
		//DaoFactory.getFactory().getSportDao().findByName(sportName)
		SportController sportController = new SportController();
		if(sportController.checkIfExistSportByName(sportName)) {
			throw new SportExistException();
		}
		sportController.createSport(sportName);
	}
	
	private void validateField(String field) throws InvalidSportFieldException {
		if(field == null || field.isEmpty()) {
			throw new InvalidSportFieldException();
		}
	}
	
}
