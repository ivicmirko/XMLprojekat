package rs.ac.uns.ftn.service1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="agent")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName="id")
public class Agent extends SystemUser {

	@Column(nullable=false)
	private Long pib;
	
	public Agent() {
		super();
	}
	
	public Agent(SystemUser user) {
		this.setName(user.getName());
		this.setSurname(user.getSurname());
		this.setUsername(user.getUsername());
		this.setEmail(user.getEmail());
		this.setPassword(user.getPassword());
		this.setAddress(user.getAddress());
		this.setPhoneNum(user.getPhoneNum());
		this.setId(user.getId());
		this.setActive(user.isEnabled());
		this.setRemoved(user.isAccountNonLocked());
		this.setAuthorities((List<Authority>) user.getAuthorities());	
	}
	

	public Agent(Long pib) {
		super();
		this.pib = pib;
	}



	public Long getPib() {
		return pib;
	}

	public void setPib(Long pib) {
		this.pib = pib;
	}
	
	
	
}
