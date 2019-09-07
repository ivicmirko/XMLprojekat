package rs.ac.uns.ftn.service1.dto;

public class AgentAddDTO {
	
	private String username;
	private String name;
	private String surname;
	private String email;
	private String address;
	private String phoneNum;
	private String password;
	private Long pib;
	
	public AgentAddDTO() {
		
	}

	public AgentAddDTO(String username, String name, String surname, String email, String address, String phoneNum,
			String password, Long pib) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.phoneNum = phoneNum;
		this.password = password;
		this.pib = pib;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPib() {
		return pib;
	}

	public void setPib(Long pib) {
		this.pib = pib;
	}
	
	

}
