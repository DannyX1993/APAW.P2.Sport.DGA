package es.upm.miw.apaw.p2.sport.entities;

import java.util.ArrayList;

public class User {

	private Integer ID;
	
	private String nick;
	
	private String email;
	
	private ArrayList<Integer> sports;
	
	public User(String nick, String email) {
		this.nick = nick;
		this.email = email;
		this.sports = new ArrayList<Integer>();
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
	
	public void addSport(Integer sportId) {
		this.sports.add(sportId);
	}
	
}
