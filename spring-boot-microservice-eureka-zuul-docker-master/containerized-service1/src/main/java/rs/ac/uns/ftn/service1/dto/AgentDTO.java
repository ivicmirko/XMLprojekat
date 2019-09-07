package rs.ac.uns.ftn.service1.dto;

public class AgentDTO {
	
	private String name;
	private String surname;
	private String username;
	private long pib;
	
	
	public AgentDTO() {
		
	}
	
	public AgentDTO(String name, String surname, String username, long pib) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.pib = pib;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getPib() {
		return pib;
	}
	public void setPib(long pib) {
		this.pib = pib;
	}
	
	

}
