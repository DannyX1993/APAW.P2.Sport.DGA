package es.upm.miw.apaw.p2.sport.entities;

import java.util.ArrayList;

public class User {

	private Integer ID;
	
	private String nick;
	
	private String email;
	
	private ArrayList<Sport> sports;
	
	public User(String nick, String email) {
		this.nick = nick;
		this.email = email;
		this.sports = new ArrayList<Sport>();
	}
	
	public Integer getId() {
		return this.ID;
	}
	
	public void setId(Integer ID) {
		this.ID = ID;
	}
	
	public String getNick() {
		return this.nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addSport(Sport sport) {
		this.sports.add(sport);
	}
	
	public ArrayList<Sport> getSports() {
		return this.sports;
	}
	
	public Sport getSportById(Integer sportId) {
		for(Sport sport : sports) {
			if(sport.getId() == sportId) {
				return sport;
			}
		}
		return null;
	}

	public boolean haveSport(Sport sport) {
		for(Sport currentSport : sports) {
			if(currentSport.equals(sport)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> getStringSportsList() {
		ArrayList<String> sportsList = new ArrayList<String>(sports.size());
		for(Sport sport : sports) {
			sportsList.add(sport.getName());
		}
		return sportsList;
	}
	
}
