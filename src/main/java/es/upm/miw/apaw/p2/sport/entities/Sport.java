package es.upm.miw.apaw.p2.sport.entities;

public class Sport {

	private Integer ID;
	
	private String name;
	
	public Sport(String name) {
		this.name = name;
	}
	
	public void setId(Integer ID) {
		this.ID = ID;
	}
	
	public Integer getId() {
		return this.ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
