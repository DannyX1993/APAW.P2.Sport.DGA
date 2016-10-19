package es.upm.miw.apaw.p2.sport.wrappers;

import java.util.List;

public class SportsListsUserWrapper {
	
	private List<String> sportsList;
	
	public SportsListsUserWrapper(List<String> sports) {
		sportsList = sports;
	}
	
	@Override
	public String toString() {
		return sportsList.toString();
	}
	
	
}
