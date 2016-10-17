package es.upm.miw.apaw.p2.sport.wrappers;

public class UserWrapper {

	private int id;
	
	private String nick;
	
	private String email;
	
	public UserWrapper(int id, String nick, String email) {
		this.id = id;
		this.nick = nick;
		this.email = email;
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
		return "{\"id\":" + id + ",\"nick\":\"" + nick + ",\"email\":\"" + email +"\"}";
	}
	
}
