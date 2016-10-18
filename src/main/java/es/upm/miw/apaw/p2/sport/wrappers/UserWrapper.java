package es.upm.miw.apaw.p2.sport.wrappers;

import java.util.ArrayList;

public class UserWrapper {

	private int id;
	
	private String nick;
	
	private String email;
	
	private ArrayList<Integer> sportsList;
	
	public UserWrapper(int id, String nick, String email, ArrayList<Integer> sportsList) {
		this.id = id;
		this.nick = nick;
		this.email = email;
		this.sportsList = sportsList;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"nick\":\"" + nick + ",\"email\":\"" + email +
				"\",\"sports\":" + sportsList + "}";
	}
	
}
