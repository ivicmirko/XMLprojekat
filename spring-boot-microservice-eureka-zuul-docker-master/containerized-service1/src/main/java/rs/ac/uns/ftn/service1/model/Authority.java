package rs.ac.uns.ftn.service1.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import rs.ac.uns.ftn.service1.enums.UserTypes;

@Entity
@Table(name="authority")
public class Authority implements GrantedAuthority {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(name="name")
	String name;
		
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return name;
	}

	public void setRolename(String name) {
		this.name = name;
	}
	
	
	
}
