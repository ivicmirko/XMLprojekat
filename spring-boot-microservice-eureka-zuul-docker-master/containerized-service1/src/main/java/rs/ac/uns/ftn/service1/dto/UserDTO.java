package rs.ac.uns.ftn.service1.dto;

import rs.ac.uns.ftn.service1.model.SystemUser;

public class UserDTO {
	
//	private long id;
	private String username;
	private String email;
	private String name;
	private String surname;
	private String address;
	private String phoneNum;
	private boolean isEnabled;
	private boolean isNotRemoved;
	
	public UserDTO() {
		
	}
	
	public UserDTO(SystemUser user) {
		this.username=user.getUsername();
		this.name=user.getName();
		this.email=user.getEmail();
		this.surname=user.getSurname();
		this.address=user.getAddress();
		this.phoneNum=user.getPhoneNum();
		this.isEnabled=user.isEnabled();
		this.isNotRemoved=user.isAccountNonLocked();
	}
	
	public UserDTO(String username, String name, String surname, String address, String phoneNum, boolean isEnabled,
			boolean isNotRemoved) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNum = phoneNum;
		this.isEnabled = isEnabled;
		this.isNotRemoved = isNotRemoved;
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
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public boolean isNotRemoved() {
		return isNotRemoved;
	}
	public void setNotRemoved(boolean isNotRemoved) {
		this.isNotRemoved = isNotRemoved;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
